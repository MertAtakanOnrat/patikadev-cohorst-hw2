package com.mertoatakan.hw2.entity;

public abstract class BaseCustomer implements IEntity{

    private final int id;

    protected BaseCustomer(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
