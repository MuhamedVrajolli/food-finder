package foodfinder.foodservice;

import foodfinder.pageable.Page;
import foodfinder.pageable.Pageable;
import foodfinder.models.FilterModel;
import foodfinder.models.FoodsModel;
import foodfinder.models.PriceCategoryModel;
import java.util.List;

public interface FoodService {
    FoodsModel getById(Long id);
    
    FoodsModel getByName(Long id, String name);
    
    FoodsModel add(FoodsModel foodsModel);
    
    FoodsModel update(Long id, FoodsModel foodsModel);
    
    List<FoodsModel> autocomplete(String s);
    
    Page<FoodsModel> filter(Pageable pageable, FilterModel filterModel, String search);
    
    List<PriceCategoryModel> getAllPriceCategories();
    
    PriceCategoryModel getPriceCategoryById(Long id);
    
    PriceCategoryModel getPriceCategoryByName(String name);

    FoodsModel delete(Long id);
}
