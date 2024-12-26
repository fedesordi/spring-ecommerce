package com.ecommerce.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private Date dateCreated;
    private Date dateDelivered;
    private double total;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "order")
    private OrderDetails details;
    public Order() {
    }

    public Order(Integer id, String number, Date dateCreated, Date dateDelivered, double total, User user) {
        this.id = id;
        this.number = number;
        this.dateCreated = dateCreated;
        this.dateDelivered = dateDelivered;
        this.total = total;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
