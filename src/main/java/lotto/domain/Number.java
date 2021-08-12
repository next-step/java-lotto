package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number>{

    private int data;

    public Number(int randomNumber) {
        this.data = randomNumber;
    }

    public boolean isBiggerThan(Number other){
        return this.data > other.data;
    }

    public int data() {
        return this.data;
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
}
