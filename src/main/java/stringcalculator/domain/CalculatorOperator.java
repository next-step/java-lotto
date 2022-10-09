package stringcalculator.domain;

public enum CalculatorOperator {

    PLUS(new Operator("+")), MINUS(new Operator("-")), MULTIPLY(new Operator("*")), DIVISION(new Operator("/"));

    private Operator operator;

    CalculatorOperator(Operator operator) {
        this.operator = operator;
    }

    public Boolean equals(Operator operator) {
        return operator.equals(this.operator);
    }
}
