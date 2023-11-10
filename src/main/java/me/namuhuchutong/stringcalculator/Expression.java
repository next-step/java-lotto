package me.namuhuchutong.stringcalculator;

public class Expression {

    private final String operator;

    private final int left;

    private final int right;

    public Expression(String operator, int left, int right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
