package stringcalculator;

import java.util.Objects;

public class Number {

    private int number;
    private static String NUMBER_CREATOR_INPUT_EXCEPTION = "Number 생성자에는 숫자만 입력 가능합니다.";

    public Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_CREATOR_INPUT_EXCEPTION);
        }
    }

    public void add(int number) {
        this.number += number;
    }

    public void minus(int number) {
        this.number -= number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
