package calculator;

public class Division implements CalculationMethod {
    @Override
    public int calculate(String operand1, String operand2) {
        if (Integer.parseInt(operand2) == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return Integer.parseInt(operand1) / Integer.parseInt(operand2);
    }
}
