package stringcalculator;

public class StringCalculator {
    public static Number calculate(Number result, Operator operator, Number number) {
        if (CalculatorOperator.PLUS.equals(operator)) {
            result.add(number);
            return result;
        }
        if (CalculatorOperator.MINUS.equals(operator)) {
            result.minus(number);
            return result;
        }
        if (CalculatorOperator.MULTIPLY.equals(operator)) {
            result.multiply(number);
            return result;
        }
        if (CalculatorOperator.DIVISION.equals(operator)) {
            result.division(number);
            return result;
        }
        throw new IllegalArgumentException(operator.OPERATOR_CREATOR_EXCEPTION);
    }
}
