package com.sano.util;

import com.sano.cars.Car;
import com.sano.cars.Electric;
import com.sano.cars.Gasoline;
import com.sano.driver.Driver;
import com.sano.driver.Skill;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static int calculateMaintenanceCostForGasolineCar(int initialcost, int currentWeek){
        int result = 0;
        for(int i = 0; i < currentWeek; i++){
            initialcost = initialcost + (initialcost / 100 * 10);
            result += initialcost;
        }
        return result -2;
    }

    public static Skill generateRandomSkillLevel(){
        Skill[] skills = Skill.values();
        int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, skills.length);
        return skills[boundedRandomValue];
    }

    public static String generateMobileNumber(int n){
        if(n < 10){
            return "0000" + n;
        }
        else if(n < 100){
            return "000" + n;
        }
        else if(n < 1000){
            return "00" + n;
        }
        else if(n < 10000){
            return "0" + n;
        }
        else return "" + n;
    }

    public static boolean trueFalse(){
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static int calculateTwoWeeksSalary(Car car){
        if(car instanceof Gasoline){
            int skillLevelValue = ((Gasoline) car).getDriver().getSkillLevel().getProfitPerWeek();
            int carValue = car.getPrice();
            return (carValue + skillLevelValue) / 26;
        }
        else if(car instanceof Electric){
            int skillLevelValue = ((Electric) car).getDriver().getSkillLevel().getProfitPerWeek();
            int carValue = car.getPrice();
            return (carValue + skillLevelValue) / 26;
        }
        else return 0;
    }
}
