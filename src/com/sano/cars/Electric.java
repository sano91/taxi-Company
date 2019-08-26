package com.sano.cars;

import com.sano.driver.Driver;

public class Electric extends Car implements Work,DriverAndPassanger {

    private Driver driver;
    private static int price = 400;

    @Override
    public int working() {
        return this.driver.getSkillLevel().getProfitPerWeek();

    }

    public Driver getDriver() {
        return this.driver;
    }

    public static int getPriceElectric(){
        return price;
    }

    @Override
    public void setPassangersPerWeek() {
        super.setPassangersPerWeek(this.working());
    }

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Electric(){
        super();
        super.price = getPriceElectric();
    }

    @Override
    public String toString() {
        return "Electric{" +
                "driver=" + driver +
                ", price=" + price +
                ", passangersPerWeek=" + passangersPerWeek +
                ", ID='" + ID + '\'' +
                '}';
    }
}
