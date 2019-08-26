package com.sano.driver;

public enum Skill {
    BEGINNER(15), ADVANCED(25), PRO(40);

    private int passangers;

    // getter method
    public int getProfitPerWeek()
    {
        return this.passangers;
    }

    // enum constructor - cannot be public or protected
    private Skill(int passangers)
    {
        this.passangers = passangers;
    }


}
