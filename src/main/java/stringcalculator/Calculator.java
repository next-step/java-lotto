package stringcalculator;

public class Calculator {
    private final Operator OPERATOR;

    Calculator(String operator) {
        OPERATOR = OperatorFactory.get(operator);
    }

    public int calculate(int a, int b) {
        return OPERATOR.calculate(a,b);
    }

}
