package model;

public enum Operator {
    PLUS("+") { public int operation(int firstNumber, int secondNumber) { return firstNumber + secondNumber; }},
    MINUS("-") { public int operation(int firstNumber, int secondNumber) { return firstNumber - secondNumber; }},
    MULTIPLE("*") { public int operation(int firstNumber, int secondNumber) { return firstNumber * secondNumber; }},
    DIVIDE("/") { public int operation(int firstNumber, int secondNumber) { return firstNumber / secondNumber; }};

    private final String operator;
    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int operation(int firstNumber, int secondNumber);

    public boolean equals(String operator) {
        return this.operator.equals(operator);
    }
}
