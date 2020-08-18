package kr.heesu.calculator.domain;

public class Result {
    private Number val;

    private Result() {
        this.val = new Number(0);
    }

    public Number getVal() {
        return this.val;
    }

    public void plus(Number operand) {
        this.val = this.val.plus(operand);
    }

//    public void plus(Number operand) {
//      this.val.plus(operand);
//    }

    @Override
    public String toString() {
        return val.toString();
    }

    public static Result of() {
        return new Result();
    }
}
