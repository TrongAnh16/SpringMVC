package com.codegym.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "senderID", foreignKey = @ForeignKey(name = "fk_senderID"))
    private Customer sender;

    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "recipientID", foreignKey = @ForeignKey(name = "fk_recipientID"))
    private Customer recipient;
    @Range(max = 999999999, min = 0)
    private double amount;
    @Range(max = 50, min = 0 )
    private double feeRate;
    private double feeAmount;
    private double totalAmount;

    public Transfer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Transfer(Long id, Customer sender, Customer recipient, double amount, double feeRate, double feeAmount, double totalAmount) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.feeRate = feeRate;
        this.feeAmount = feeAmount;
        this.totalAmount = totalAmount;
    }
}
