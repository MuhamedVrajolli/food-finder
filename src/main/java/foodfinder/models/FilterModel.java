package foodfinder.models;

import java.util.List;

public class FilterModel {
    private Integer minTime;
    private Integer maxTime;
    private List<Long> priceCategories;
    private Boolean isDessert;

    public Integer getMinTime() {
        return minTime;
    }

    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public List<Long> getPriceCategories() {
        return priceCategories;
    }

    public void setPriceCategories(List<Long> priceCategories) {
        this.priceCategories = priceCategories;
    }

    public Boolean getIsDessert() {
        return isDessert;
    }

    public void setIsDessert(Boolean isDessert) {
        this.isDessert = isDessert;
    }
    
    
}
