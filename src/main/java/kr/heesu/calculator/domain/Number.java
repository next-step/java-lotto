package kr.heesu.calculator.domain;

public class Number {
    private int val;

    public Number(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.val = number;
    }

    public Number plus(Number operand) {
        return new Number(this.val + operand.getVal());
    }

//    public void plus(Number operand) {
//        this.val += operand.getVal();
//    }

    public int getVal() {
        return this.val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
