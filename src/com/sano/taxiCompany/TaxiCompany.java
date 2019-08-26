package com.sano.taxiCompany;

import com.sano.cars.Car;
import com.sano.cars.Electric;
import com.sano.cars.Gasoline;
import com.sano.cars.SelfDriving;
import com.sano.driver.Driver;
import com.sano.util.Util;

import java.util.HashSet;
import java.util.Set;

public class TaxiCompany {
    private static int mobile = 1;
    private Set<Car> cabs;
    private Set<Driver> drivers;
    private int money;

    private static int totalPassangers = 0;

    private TaxiCompany(int money) {
        this.money = money;
        this.cabs = new HashSet<>();
        this.drivers = new HashSet<>();
    }

    private void initArsenal(HashSet<Car> cars) {
        for (Car car : cars) {
            if (car instanceof Gasoline) {
                Driver driver = new Driver(Util.generateMobileNumber(mobile));
                mobile++;
                ((Gasoline) car).setDriver(driver);
                cabs.add(car);
            } else if (car instanceof Electric) {
                Driver driver = new Driver(Util.generateMobileNumber(mobile));
                mobile++;
                ((Electric) car).setDriver(driver);
                cabs.add(car);
                drivers.add(driver);
            } else if (car instanceof SelfDriving) {
                cabs.add(car);
            }
        }
    }

    private void buyNewUnit() {
        buyElectricOrSelfDriving();
    }


    private void buyElectricOrSelfDriving() {
        if (Util.trueFalse()) {
            Electric car = new Electric();
            Driver driver = new Driver(Util.generateMobileNumber(mobile));
            mobile++;
            car.setDriver(driver);
            cabs.add(car);
            drivers.add(driver);
        } else {
            SelfDriving selfDriving = new SelfDriving();
            this.money += selfDriving.working();
            totalPassangers += selfDriving.working();
            cabs.add(selfDriving);
        }
    }

    private void gasoline(int w, Gasoline gasoline) {
        if (w % 2 == 0) {
            money += gasoline.working();
            totalPassangers += gasoline.working();
            money -= Util.calculateTwoWeeksSalary(gasoline);
            gasoline.getDriver().takeSalary(Util.calculateTwoWeeksSalary(gasoline));
            money -= gasoline.maintanenceCost(w);
        } else {
            money += gasoline.working();
            totalPassangers += gasoline.working();
        }
    }


    private void electric(int w, Electric electric) {
        if (w % 2 == 0) {
            money += electric.working();
            totalPassangers += electric.working();
            money -= Util.calculateTwoWeeksSalary(electric);
            electric.getDriver().takeSalary(Util.calculateTwoWeeksSalary(electric));
        } else {
            money += electric.working();
            totalPassangers += electric.working();
        }

    }


    private int simulateWeeks(int weeks, int minimumMoneyForBuyNewUnit) {
        for (int i = 1; i <= weeks; i++) {
            if (this.money > minimumMoneyForBuyNewUnit) {     // case buy a new car
                buyNewUnit();
                for (Car car : cabs) {
                    if (car instanceof SelfDriving) {
                        ((SelfDriving) car).repair();
                    } else {
                        if (car instanceof Gasoline) {
                            gasoline(i, (Gasoline) car);
                        } else if (car instanceof Electric) {
                            electric(i, (Electric) car);
                        }


                    }
                }
            } else {
                for (Car car : cabs) {
                    if (car instanceof Gasoline) {
                        gasoline(i, (Gasoline) car);
                    } else if (car instanceof Electric) {
                        electric(i, (Electric) car);
                    } else if (car instanceof SelfDriving) {
                        money += ((SelfDriving) car).working();
                        totalPassangers += ((SelfDriving) car).working();
                    }
                }
            }
        }
        return this.money;
    }


    @Override
    public String toString() {
        return "TaxiCompany{" +
                "cabs=" + cabs.toString() +

                ", money=" + money +
                '}';
    }

    public static void main(String[] args) {
        HashSet<Car> starterCars = new HashSet<>();
        //starterCars.add(new SelfDriving());
        //starterCars.add(new Electric());
        //starterCars.add(new Electric());
        starterCars.add(new Electric());
        starterCars.add(new Electric());
        TaxiCompany taxiCompany = new TaxiCompany(200);
        taxiCompany.initArsenal(starterCars);
        System.out.println(taxiCompany.simulateWeeks(2, 1000));
        System.out.println(taxiCompany.toString());
        System.out.println(totalPassangers);

    }

}
