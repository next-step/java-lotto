package step1.domain;

import java.util.List;

public class Number {

    private Integer number;

    private static void checkBiggerThanZero(Integer input) {
        if (input < 0) {
            throw new RuntimeException("0보다 작은 값이 존재합니다.");
        }
    }

    public Number(Integer number) {
        checkBiggerThanZero(number);
        this.number = number;
    }


    public Integer getNum() {
        return number;
    }

    public Number add(Number num2) {
        return new Number(number + num2.getNum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number numberTarget = (Number) o;
        return number != null ? number.equals(numberTarget.number) : numberTarget.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
