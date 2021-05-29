package lotto.domain;

import java.util.Objects;

public class RankCounter {

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public void addFirst() {
        first++;
    }

    public void addSecond() {
        second++;
    }

    public void addThird() {
        third++;
    }

    public void addFourth() {
        fourth++;
    }

    public void addFifth() {
        fifth++;
    }

    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    public int third() {
        return third;
    }

    public int fourth() {
        return fourth;
    }

    public int fifth() {
        return fifth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankCounter rankCounter = (RankCounter) o;
        return first == rankCounter.first && second == rankCounter.second && third == rankCounter.third && fourth == rankCounter.fourth && fifth == rankCounter.fifth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth, fifth);
    }
}
