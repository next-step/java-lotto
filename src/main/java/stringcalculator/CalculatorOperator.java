package stringcalculator;

public enum CalculatorOperator {

    PLUS(new Operator("+")), MINUS(new Operator("-")), MULTIPLY(new Operator("*")), DIVISION(new Operator("/"));

    private final Operator operator;

    CalculatorOperator(Operator operator) {
        this.operator = operator;
    }
}
