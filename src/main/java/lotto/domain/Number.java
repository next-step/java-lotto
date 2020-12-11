package lotto.domain;

import lotto.utils.ValidationChecker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Number implements Comparable<Number>{
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static Map<Integer, Number> number = new HashMap<>();
    private int num;

    static {
        IntStream.rangeClosed(START_NUM, END_NUM).forEach(i -> number.put(i, new Number(i)));
    }

    private Number(int number) {
        this.num = number;
    }

    public static Number of(String sDigit) {
        ValidationChecker.exceptionCheck(sDigit);
        return of(Integer.parseInt(sDigit));
    }

    public static Number of(int digit) {
        return number.get(digit);
    }

    public int getNum() {
        return num;
    }

    public static List<Number> initialNumber() {
        return IntStream.rangeClosed(START_NUM, END_NUM).
                mapToObj(i -> number.get(i)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public int compareTo(Number number) {
        if (this.num < number.num) return -1;
        if (this.num == number.num) return 0;
        return 1;
    }
}
