package com.tommunyiri.covid_19stats.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaginationMeta {
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("currentPageSize")
    @Expose
    private Integer currentPageSize;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(Integer currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}
