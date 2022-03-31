package foodfinder.foodservice;

import foodfinder.config.DataSource;
import foodfinder.pageable.Page;
import foodfinder.pageable.Pageable;
import static foodfinder.jooq.Tables.*;
import foodfinder.models.FilterModel;
import foodfinder.models.FoodsModel;
import foodfinder.models.PriceCategoryModel;
import foodfinder.pageable.Sort;
import java.util.List;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SortField;
import org.jooq.SortOrder;
import org.jooq.impl.DSL;

public class FoodRepositoryImpl implements FoodRepository{
    private DSLContext create;

    public FoodRepositoryImpl() {
        create = DataSource.getContext();
    }

    @Override
    public FoodsModel getById(Long id) {
        FoodsModel foodsModel = create.selectFrom(FOODS)
                .where(FOODS.ID.eq(id))
                .fetchOneInto(FoodsModel.class);
        
        getFoodDetails(foodsModel);
        
        return foodsModel;
    }

    @Override
    public FoodsModel getByName(Long id, String name) {
        Condition condition = DSL.trueCondition();
        
        if(id != null){
            condition = condition.and(FOODS.ID.ne(id));
        }
        
        FoodsModel foodsModel = create.selectFrom(FOODS)
                .where(FOODS.NAME.equalIgnoreCase(name))
                .and(condition)
                .and(FOODS.IS_ACTIVE)
                .fetchOneInto(FoodsModel.class);
        
        getFoodDetails(foodsModel);
        
        return foodsModel;
    }

    @Override
    public FoodsModel add(FoodsModel foodsModel) {
        FoodsModel createdModel = create.insertInto(FOODS)
                .set(FOODS.NAME, foodsModel.getName())
                .set(FOODS.PREPARATION_TIME, foodsModel.getPreparationTime())
                .set(FOODS.PRICE_CATEGORY, foodsModel.getPriceCategory())
                .set(FOODS.IS_DESSERT, foodsModel.getIsDessert())
                .returning()
                .fetchOne().into(FoodsModel.class);
        
        getFoodDetails(createdModel);
        
        return createdModel;
    }

    @Override
    public FoodsModel update(Long id, FoodsModel foodsModel) {
        FoodsModel updatedModel = create.update(FOODS)
                .set(FOODS.NAME, foodsModel.getName())
                .set(FOODS.PREPARATION_TIME, foodsModel.getPreparationTime())
                .set(FOODS.PRICE_CATEGORY, foodsModel.getPriceCategory())
                .set(FOODS.IS_DESSERT, foodsModel.getIsDessert())
                .where(FOODS.ID.eq(id))
                .returning()
                .fetchOne().into(FoodsModel.class);
        
        getFoodDetails(updatedModel);
        
        return updatedModel;
    }

    @Override
    public List<FoodsModel> autocomplete(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<FoodsModel> filter(Pageable pageable, FilterModel filterModel, String search) {
        Sort sort = pageable.getSort();
        SortField<?> order = null;
        if(sort != null){
            order = DSL.field(sort.getField())
                .sort(sort.getDirection().equals(Sort.ASC) ? SortOrder.ASC : SortOrder.DESC);
        }
        
        Condition condition = DSL.trueCondition();
        
        if(filterModel != null){
            if(filterModel.getPriceCategories() != null){
                condition = condition.and(FOODS.PRICE_CATEGORY.in(filterModel.getPriceCategories()));
            }
        
            if(filterModel.getMinTime() != null && filterModel.getMaxTime() != null){
                condition = condition.and(FOODS.PREPARATION_TIME.between(filterModel.getMinTime(), filterModel.getMaxTime()));
            }

            if(filterModel.getIsDessert() != null){
                condition = condition.and(FOODS.IS_DESSERT.eq(filterModel.getIsDessert()));
            }
        }
        if (search != null){
            condition = condition.and(FOODS.NAME.containsIgnoreCase(search));
        }
    
        int totalElements = create.selectCount().from(FOODS)
                .where(condition)
                .and(FOODS.IS_ACTIVE)
                .fetchOneInto(int.class);
        
        List<FoodsModel> content = create.selectFrom(FOODS)
                .where(condition)
                .and(FOODS.IS_ACTIVE)
                .orderBy(order != null? order : FOODS.ID)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchInto(FoodsModel.class);
        
        for (FoodsModel foodsModel: content){
            getFoodDetails(foodsModel);
        }
        
        return new Page<>(content, pageable, totalElements);
    }

    @Override
    public List<PriceCategoryModel> getAllPriceCategories() {
        return create.selectFrom(PRICE_CATEGORIES)
                .where(PRICE_CATEGORIES.IS_ACTIVE)
                .fetchInto(PriceCategoryModel.class);
    }

    @Override
    public PriceCategoryModel getPriceCategoryById(Long id) {
        return create.selectFrom(PRICE_CATEGORIES)
                .where(PRICE_CATEGORIES.ID.eq(id))
                .fetchOneInto(PriceCategoryModel.class);
    }

    @Override
    public FoodsModel delete(Long id) {
        return create.update(FOODS)
                .set(FOODS.IS_ACTIVE, false)
                .where(FOODS.ID.eq(id))
                .returning()
                .fetchOne().into(FoodsModel.class);
    }
    
    private void getFoodDetails(FoodsModel foodsModel){
        if(foodsModel != null){
            foodsModel.setPriceCategoryModel(getPriceCategoryById(foodsModel.getPriceCategory()));
        }
    }

    @Override
    public PriceCategoryModel getPriceCategoryByName(String name) {
        return create.selectFrom(PRICE_CATEGORIES)
                .where(PRICE_CATEGORIES.CATEGORY.eq(name))
                .fetchOneInto(PriceCategoryModel.class);
    }
}
