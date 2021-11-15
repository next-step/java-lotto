package calculator;

import java.util.Objects;

public class Number {

    private static final int MINIMUM_NUMBER = 1;

    private final int result;

    private Number(int result) {
        this.result = result;
    }

    public static Number add(String splitNumber1, String splitNumber2) {
        int result = getInt(splitNumber1) + getInt(splitNumber2);
        return new Number(result);
    }

    private static int getInt(String splitNumber) {
        int number = stringToInt(splitNumber);
        valid(number);

        return number;
    }

    private static int stringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 이외의 값은 입력할 수 없습니다. " + e.getMessage());
        }
    }

    private static void valid(int number) {
        if(number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("숫자는 %d보다 작을 수 없습니다.", MINIMUM_NUMBER));
        }
    }

    public int getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return result == number.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
