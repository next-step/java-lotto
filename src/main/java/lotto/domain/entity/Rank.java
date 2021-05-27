package lotto.domain.entity;

import java.util.Objects;

public class Rank {

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return first == rank.first && second == rank.second && third == rank.third && fourth == rank.fourth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth);
    }
}
