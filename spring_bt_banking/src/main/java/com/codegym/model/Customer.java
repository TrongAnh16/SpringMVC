package com.codegym.model;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String created_at;
    private String created_by;
    private String deleted;
    private String updated_at;
    private String updated_by;
    private String full_name;
    private int balance;
    private String email;
    private String address;
    private String phone;

    public Customer() {}

    public Customer(Long id, String created_at, String created_by, String deleted, String updated_at, String updated_by, String full_name, int balance, String email, String address, String phone) {
        this.id = id;
        this.created_at = created_at;
        this.created_by = created_by;
        this.deleted = deleted;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.full_name = full_name;
        this.balance = balance;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", deleted='" + deleted + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                ", full_name='" + full_name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}