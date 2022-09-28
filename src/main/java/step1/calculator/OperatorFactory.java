package step1.calculator;

public class OperatorFactory {
    public static Calculator createOperator(String operator) {
        if(operator.equals("+")){
            return new AddCalculator();
        };

        if (operator.equals("-")) {
            return new MinusCalculator();
        };

        if (operator.equals("*")) {
            return new MultiplyCalculator();
        };

        if (operator.equals("/")) {
            return new DivideCalculator();
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
