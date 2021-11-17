package step2.domain;

import step2.utils.RandomUtils;

public class Number {
    private int number;

    private Number() {
        this.number = RandomUtils.nextInt();
    }

    private Number(String number) {
        this.number = Integer.parseInt(number);
    }

    public static Number create() {
        return new Number();
    }

    public static Number of(String number) {
        return new Number(number);
    }

    public int getNumber() {
        return number;
    }

    public String getStringNumber() {
        return String.valueOf(number);
    }
}
