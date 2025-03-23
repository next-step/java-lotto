package tutorial.calculator;

public class CalculatorFactory {
    public AbstractCalculator getCalculator(String operator) {
        if (operator.equals("+")) {
            return new PlusCalculator();
        }
        if (operator.equals("-")) {
            return new MinusCalculator();
        }
        if (operator.equals("*")) {
            return new MultiplyCalculator();
        }
        if (operator.equals("/")) {
            return new DivideCalculator();
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다. : " + operator);
    }
}
