package com.mertoatakan.hw2.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseCustomer implements IEntity{

    private static final Set<Integer> ids = new HashSet<>();
    private final int id;
    protected String name;
    protected LocalDate registrationDate;

    public BaseCustomer(String name, LocalDate registrationDate) {
        this.id = generateId();
        this.name = name;
        this.registrationDate = registrationDate;
    }

    private static synchronized int generateId(){
        int newId = ids.size() + 1;
        while (!ids.add(newId)){
            newId++;
        }
        return newId;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public abstract void printCustomerDetails();
}
