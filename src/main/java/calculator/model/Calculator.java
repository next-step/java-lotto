package calculator.model;

public class Calculator {
    InputNumber number;
    Operator operator;

    public Calculator(InputNumber number, Operator operator) {
        this.number = number;
        this.operator = operator;
    }

    public int calculate() {
        int result = number.numbers.get(0);
        for (int i = 0; i < operator.operators.size(); i++) {
            result = calculate(operator.operators.get(i), result, number.numbers.get(i + 1));

        }
        return result;
    }
    private int calculate(String operator, int leftInteger, int rightInteger){
        if ("+".equals(operator)) {
            return leftInteger + rightInteger;
        }
        if ("-".equals(operator)) {
            return leftInteger - rightInteger;
        }
        if ("*".equals(operator)) {
            return leftInteger * rightInteger;
        }
        return leftInteger / rightInteger;
    }
}
