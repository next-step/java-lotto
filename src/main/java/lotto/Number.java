package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Number implements Comparable<Number> {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public int compareTo(Number other) {
        return Integer.compare(this.number, other.number);
    }

    public static List<Number> of(int... numbers){
        List<Number> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(Number.of(number));
        }
        return numberList;
    }

    public static Number of(int number){
        return new Number(number);
    }

    public static Number of(String number){
        return Number.of(Integer.parseInt(number));
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
        return String.valueOf(number);
    }
}
