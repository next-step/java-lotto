package stringcalculator.domain.calculation;

public class Division implements Calculation {
    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    }
}
