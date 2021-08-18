package lotto.domain;

import lotto.util.RandomUtil;

import java.util.*;

public class Number implements Comparable<Number> {

    private int data;

    public Number(int number) {
        this.data = number;
    }

    public boolean isBiggerThan(Number other) {
        return this.data > other.data;
    }

    public int data() {
        return this.data;
    }

    public static List<Number> createRandomNumbers(int size) {
        Set<Number> numberSet = new HashSet<>();
        while (numberSet.size() != size) {
            Number randomNumber = createRandomNumber();
            numberSet.add(randomNumber);
        }
        List<Number> randomNumbers = new ArrayList<>(numberSet);
        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }

    private static Number createRandomNumber() {
        return new Number(RandomUtil.getRandomNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return data == number.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public int compareTo(Number o) {
        return this.data - o.data;
    }


    @Override
    public String toString() {
        return "" + data;
    }
}
