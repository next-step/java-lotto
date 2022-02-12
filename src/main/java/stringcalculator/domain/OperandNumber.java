package stringcalculator.domain;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(String number) {
        this(validatePositiveNumber(number));
    }
    public Number(int number){
        this.number = number;
    }

    public static int validatePositiveNumber(String token) {
        final int intToken = convertTypeOfToken(token);
        if (intToken < 0) {
            throw new IllegalArgumentException("[Error]: 양수만 연산 가능합니다.");
        }
        return intToken;
    }

    public static int convertTypeOfToken(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[Error]: 숫자만 연산 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
