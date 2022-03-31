package foodfinder.models;

public class FoodsModel extends BaseModel{
    private String name;
    private Integer preparationTime;
    private Long priceCategory;
    private PriceCategoryModel priceCategoryModel;
    private boolean isDessert;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Long getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(Long priceCategory) {
        this.priceCategory = priceCategory;
    }

    public PriceCategoryModel getPriceCategoryModel() {
        return priceCategoryModel;
    }

    public void setPriceCategoryModel(PriceCategoryModel priceCategoryModel) {
        this.priceCategoryModel = priceCategoryModel;
    }

    public boolean getIsDessert() {
        return isDessert;
    }

    public void setIsDessert(boolean isDessert) {
        this.isDessert = isDessert;
    }
    
    
}
