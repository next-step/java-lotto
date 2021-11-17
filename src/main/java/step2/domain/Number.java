package step2.domain;

import step2.utils.RandomUtils;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int number;

    private Number() {
        this.number = RandomUtils.nextInt();
    }

    private Number(String number) {
        int value = Integer.parseInt(number);
        validateNumberBound(value);
        this.number = value;
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

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 숫자 범위입니다.");
        }
    }
}
