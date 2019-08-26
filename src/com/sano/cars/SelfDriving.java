package com.sano.cars;

public class SelfDriving extends Car implements Work {
    private static int price = 740;

    @Override
    public int working() {
        return 70;
    }


    public static int getPriceSelfDriving() {
        return price;
    }

    public SelfDriving() {
        super(price);
        super.passangersPerWeek = working();
    }

    @Override
    public String toString() {
        return "SelfDriving{" +
                "price=" + price +
                ", passangersPerWeek=" + passangersPerWeek +
                ", ID='" + ID + '\'' +
                '}';
    }

    public int repair(){
        return 0;
    }
}
