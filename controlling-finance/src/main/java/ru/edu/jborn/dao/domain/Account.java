package ru.edu.jborn.dao.domain;

import java.math.BigDecimal;

public class Account {

    private Integer id;
    private Integer user_id;
    private BigDecimal balance;
    private String name;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }

    public Account(Integer id, Integer user_id, BigDecimal balance, String name) {
        this.id = id;
        this.user_id = user_id;
        this.balance = balance;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
