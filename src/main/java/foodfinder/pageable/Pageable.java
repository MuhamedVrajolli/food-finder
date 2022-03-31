package foodfinder.pageable;

public class Pageable {
    private int pageNumber;
    private int pageSize;
    private int offset;
    private Sort sort;

    public Pageable() {
    }

    public Pageable(int pageNumber, int pageSize, Sort sort) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.offset = pageNumber * pageSize;
        this.sort = sort;
    }
    
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
