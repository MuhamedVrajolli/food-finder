package foodfinder.foodservice;

import foodfinder.pageable.Page;
import foodfinder.pageable.Pageable;
import foodfinder.models.FilterModel;
import foodfinder.models.FoodsModel;
import foodfinder.models.PriceCategoryModel;
import java.util.List;

public class FoodServiceImpl implements FoodService{
    private FoodRepository foodRepository;

    public FoodServiceImpl() {
        foodRepository = new FoodRepositoryImpl();
    }
    
    @Override
    public FoodsModel getById(Long id) {
        return foodRepository.getById(id);
    }

    @Override
    public FoodsModel add(FoodsModel foodsModel) {
        FoodsModel check = foodRepository.getByName(null, foodsModel.getName());
        if (check != null){
            throw new RuntimeException("The food you are trying to insert already exists");
        }
        return foodRepository.add(foodsModel);
    }

    @Override
    public FoodsModel update(Long id, FoodsModel foodsModel) {
        FoodsModel check = foodRepository.getByName(id, foodsModel.getName());
        if (check != null){
            throw new RuntimeException("The food you are trying to insert already exists");
        }
        return foodRepository.update(id, foodsModel);
    }

    @Override
    public List<FoodsModel> autocomplete(String s) {
        return foodRepository.autocomplete(s);
    }

    @Override
    public Page<FoodsModel> filter(Pageable pageable, FilterModel filterModel, String search) {
        return foodRepository.filter(pageable, filterModel, search);
    }

    @Override
    public List<PriceCategoryModel> getAllPriceCategories() {
        return foodRepository.getAllPriceCategories();
    }

    @Override
    public PriceCategoryModel getPriceCategoryById(Long id) {
        return foodRepository.getPriceCategoryById(id);
    }

    @Override
    public PriceCategoryModel getPriceCategoryByName(String name) {
        return foodRepository.getPriceCategoryByName(name);
    }

    @Override
    public FoodsModel delete(Long id) {
        return foodRepository.delete(id);
    }

    @Override
    public FoodsModel getByName(Long id, String name) {
        return foodRepository.getByName(id, name);
    }
}
