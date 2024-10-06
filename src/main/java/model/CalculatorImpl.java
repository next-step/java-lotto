package model;

public class CalculatorImpl implements Calculator {

    @Override
    public Integer calculate(Integer num1, Integer num2, String operator) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int res;
        switch (operator) {
            case "+":
                res = Operator.add(num1, num2);
                break;
            case "-":
                res = Operator.minus(num1, num2);
                break;
            case "*":
                res = Operator.multiply(num1, num2);
                break;
            case "/":
                res = Operator.divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return res;
    }
}
