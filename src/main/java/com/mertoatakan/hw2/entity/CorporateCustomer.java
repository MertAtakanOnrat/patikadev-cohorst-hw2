package com.mertoatakan.hw2.entity;

import java.time.LocalDate;

public class CorporateCustomer extends BaseCustomer{
    private String taxId;
    private String sector;

    public CorporateCustomer(String name, LocalDate registrationDate, String taxId, String sector) {
        super(name, registrationDate);
        this.taxId = taxId;
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public void printCustomerDetails() {
        System.out.println("Corporate Customer: " + this.name + ", Tax ID: " + this.taxId);
    }
}
