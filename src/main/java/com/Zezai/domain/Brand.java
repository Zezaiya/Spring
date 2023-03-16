package com.Zezai.domain;

public class Brand {
    // id 主键
    private Integer id;
    // 品牌名称
    private String brand_Name;
    // 企业名称
    private String company_Name;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;


    public Brand() {
    }

    public Brand(Integer id, String brandName, String companyName, String description) {
        this.id = id;
        this.brand_Name = brandName;
        this.company_Name = companyName;
        this.description = description;
    }

    public Brand(Integer id, String brandName, String companyName, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brand_Name = brandName;
        this.company_Name = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brand_Name;
    }

    public void setBrandName(String brandName) {
        this.brand_Name = brandName;
    }

    public String getCompanyName() {
        return company_Name;
    }

    public void setCompanyName(String companyName) {
        this.company_Name = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {       return "Brand{" +
                "id=" + id +
                ", brandName='" + brand_Name + '\'' +
                ", companyName='" + company_Name + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

}