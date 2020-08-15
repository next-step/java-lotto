package kr.heesu.calculator.domain;

public class Result {
    private int result;

    private Result() {
        this.result = 0;
    }

    public void next(int operand, Operator operator) {
        this.result = operator.operate(this.result, operand);
    }

    public int getVal() {
        return this.result;
    }

    public static Result of() {
        return new Result();
    }
}
