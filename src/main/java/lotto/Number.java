package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Number implements Comparable<Number> {
    private int number;

가    public Number(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("로또 번호는 음수가 될 수 없습니다.");
        }
        this.number = number;
    }

    public static Number createNumber(int number) {
        return new Number(number);
    }

    public static Number createNumber(String numberString) {
        int numberInt = Integer.parseInt(numberString);
        return new Number(numberInt);
    }

    public static List<Number> createNumberList(List<Integer> integerList) {
        return integerList.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public String getNumberToString() {
        return String.valueOf(number);
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
    public int compareTo(Number o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
