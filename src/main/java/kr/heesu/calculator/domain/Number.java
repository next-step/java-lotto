package kr.heesu.calculator.domain;

public class Number {
    private int val;

    public Number(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.val = number;
    }

    public int getVal() {
        return this.val;
    }
}
