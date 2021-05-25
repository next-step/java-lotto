package lotto.domain.entity;

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
}
