package foodfinder.pageable;

public class Sort {
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    
    private String field;
    private String direction;

    public Sort() {
    }

    public Sort(String field, String direction) {
        this.field = field;
        this.direction = direction;
    }
    

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
