package com.ecommerce.model;

import java.util.Date;

public class Order {
    private Integer id;
    private String number;
    private Date dateCreated;
    private Date dateDelivered;
    private double total;

    public Order() {
    }

    public Order(Integer id, String number, Date dateCreated, Date dateDelivered, double total) {
        this.id = id;
        this.number = number;
        this.dateCreated = dateCreated;
        this.dateDelivered = dateDelivered;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateDelivered=" + dateDelivered +
                ", total=" + total +
                '}';
    }
}
