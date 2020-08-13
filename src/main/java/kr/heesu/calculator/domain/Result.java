package kr.heesu.calculator.domain;

public class Result {
    private int result;

    private Result() {
        this.result = 0;
    }

    public void set(int interMediateResult) {
        this.result = interMediateResult;
    }

    public int getVal() {
        return this.result;
    }

    public static Result of() {
        return new Result();
    }
}
