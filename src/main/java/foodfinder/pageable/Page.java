package foodfinder.pageable;

import java.util.List;

public class Page<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean isSorted;
    private boolean isLastPage;

    public Page(List<T> content, Pageable pageable, int totalElements) {
        this.content = content;
        this.totalElements = totalElements;
        this.pageNumber = pageable.getPageNumber();
        this.pageSize = pageable.getPageSize();
        this.totalPages = totalElements / pageSize;
        this.isSorted = pageable.getSort() != null;
        this.isLastPage = pageNumber == totalPages;
    }
    
    

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
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

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isIsSorted() {
        return isSorted;
    }

    public void setIsSorted(boolean isSorted) {
        this.isSorted = isSorted;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }
}
