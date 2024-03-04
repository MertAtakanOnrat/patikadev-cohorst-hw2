package com.mertoatakan.hw2.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Invoice {
    private static final Set<Integer> ids = new HashSet<>();
    private final int id;
    private final int customerId;
    private final double amount;
    private final LocalDate date;

    public Invoice(int customerId, double amount, LocalDate date) {
        this.id = generateId();
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    private static synchronized int generateId() {
        int newId = ids.size() + 1;
        while (!ids.add(newId)){
            newId++;
        }
        return newId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
