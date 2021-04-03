package com.market.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private Integer idProducts;
    private String name;
    @Column(name = "id_categories")
    private Integer idCategories;
    private String barcode;
    @Column(name = "sale_price")
    private Double salePrice;
    @Column(name = "stock_lot")
    private Integer stockLot;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_categories", insertable = false, updatable = false)
    private Category categoryAdd;

    public Integer getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Integer idProducts) {
        this.idProducts = idProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Integer idCategories) {
        this.idCategories = idCategories;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStockLot() {
        return stockLot;
    }

    public void setStockLot(Integer stockLot) {
        this.stockLot = stockLot;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategoryAdd() {
        return categoryAdd;
    }

    public void setCategoryAdd(Category categoryAdd) {
        this.categoryAdd = categoryAdd;
    }
}
