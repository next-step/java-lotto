package step2.domain;

import step2.utils.RandomUtils;

public class Number {
    private int number;

    private Number() {
        this.number = RandomUtils.nextInt();
    }

    public static Number create() {
        return new Number();
    }

    public int getNumber() {
        return number;
    }

    public String getStringNumber() {
        return String.valueOf(number);
    }
}
