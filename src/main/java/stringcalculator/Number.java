package stringcalculator;

import java.util.Objects;

public class Number {

    private int number;
    private static String NUMBER_CREATOR_INPUT_EXCEPTION = "Number 생성자에는 숫자만 입력 가능합니다.";
    private static String DIVISION_ZERO_EXCEPTION = "0으로 나눌 수 없습니다.";

    public Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_CREATOR_INPUT_EXCEPTION);
        }
    }

    public void add(Number number) {
        this.number += number.toInt();
    }

    public void minus(Number number) {
        this.number -= number.toInt();
    }

    public void multiply(Number number) {
        this.number *= number.toInt();
    }

    public void division(Number number) {
        if (number.toInt() == 0) {
            throw new IllegalArgumentException(DIVISION_ZERO_EXCEPTION);
        }
        this.number /= number.toInt();
    }

    private int toInt(){
        return number;
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

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
