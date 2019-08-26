package com.sano.cars;

import com.sano.util.Util;

public abstract class Car {

    protected int price;
    protected int passangersPerWeek;
    final protected String ID;


    public Car(int price, int passangersPerWeek) {
        this.price = price;
        this.passangersPerWeek = passangersPerWeek;
        this.ID = Util.generateID();
    }

    public String getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPassangersPerWeek() {
        return passangersPerWeek;
    }

    void setPassangersPerWeek(int passangersPerWeek) {
        this.passangersPerWeek = passangersPerWeek;
    }

    Car(int price) {
        this.price = price;
        this.ID = Util.generateID();
    }

    Car(){
        this.ID = Util.generateID();
    }


}
