package com.mertoatakan.hw2.entity;

import java.time.LocalDate;

public class IndividualCustomer extends BaseCustomer{

    private String personalId;

    public IndividualCustomer(String name, LocalDate registrationDate, String personalId) {
        super(name, registrationDate);
        this.personalId = personalId;
    }
    @Override
    public void printCustomerDetails() {
        System.out.println("Individual Customer: " + this.name + ", ID: " + this.personalId);
    }
}
