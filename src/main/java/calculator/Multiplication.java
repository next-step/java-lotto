package calculator;

public class Multiplication implements CalculationMethod {
    @Override
    public int calculate(String operand1, String operand2) {
        return Integer.parseInt(operand1) * Integer.parseInt(operand2);
    }
}
