package com.fys.util;

/**
 *  分页工具
 */
public class Page {
    private Integer totalCount;
    private Integer totalPage;
    private Integer pageSize = 10;
    private Integer currentPage = 1;

    /**
     *   初始化总页数
     * @param totalCount 总记录数
     */
    public void init(Integer totalCount) {
        this.totalCount = totalCount;
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
