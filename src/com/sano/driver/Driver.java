package com.sano.driver;

import com.sano.util.Util;

import java.util.HashSet;
import java.util.Set;

public class Driver {

    private static Set<String>mobilNumbersInCompany = new HashSet<>();
    private int salary = 0;
    private String name;
    private Skill skillLevel;
    private String mobilNumber;

    public void takeSalary(int salary){
        this.salary += salary;
    }


    public String getName() {
        return name;
    }

    public Skill getSkillLevel() {
        return skillLevel;
    }

    public void setMobilNumber(String mobilNumber) {
        this.mobilNumber = mobilNumber;
        mobilNumbersInCompany.add(this.mobilNumber);
    }

    public Driver(String name, String mobilNumber) {
        this.name = name;
        this.mobilNumber = mobilNumber;
        mobilNumbersInCompany.add(this.mobilNumber);
    }

    public Driver(String mobilNumber) {
        this.mobilNumber = mobilNumber;
        this.skillLevel = Util.generateRandomSkillLevel();
    }

    public Driver() {
        this.skillLevel = Util.generateRandomSkillLevel();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", mobilNumber='" + mobilNumber + '\'' +
                '}';
    }
}
