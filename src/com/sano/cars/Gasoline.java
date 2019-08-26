package com.sano.cars;

import com.sano.driver.Driver;
import com.sano.util.Util;

public class Gasoline extends Car implements Work, DriverAndPassanger{

    private Driver driver;
    private int initialMaintenenceCost = 20;
    private static int price = 350;

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int maintanenceCost(int week){
        return Util.calculateMaintenanceCostForGasolineCar(initialMaintenenceCost, week);
    }

    public Driver getDriver() {
        return this.driver;
    }

    @Override
    public int working() {

        return this.driver.getSkillLevel().getProfitPerWeek();
    }


    private static int getPriceGasoline() {
        return price;
    }


    public Gasoline() {
        super();
        super.price = getPriceGasoline();
    }

    @Override
    public void setPassangersPerWeek() {
        super.setPassangersPerWeek(this.working());
    }

    @Override
    public String toString() {
        return "Gasoline{" +
                "driver=" + driver +
                ", initialMaintenenceCost=" + initialMaintenenceCost +
                ", price=" + price +
                ", passangersPerWeek=" + passangersPerWeek +
                ", ID='" + ID + '\'' +
                '}';
    }
}
