package stringcalculator.service;

public enum Operator {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
