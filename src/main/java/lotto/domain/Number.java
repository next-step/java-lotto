package lotto.domain;

public class Number {
    private int data;

    public Number(int randomNumber) {
        this.data = randomNumber;
    }

    public boolean isBiggerThan(Number other){
        return this.data > other.data;
    }
}
