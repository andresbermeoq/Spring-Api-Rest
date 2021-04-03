package com.market.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "Sales_Products")
public class SalesProduct {

    @EmbeddedId
    private SalesProductPK id;
    private Integer amount;
    private Double total;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_sale", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;


    public SalesProductPK getId() {
        return id;
    }

    public void setId(SalesProductPK id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
