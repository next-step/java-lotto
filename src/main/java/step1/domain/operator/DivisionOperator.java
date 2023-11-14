package step1.domain.operator;

public class DivisionOperator implements Operator {

    @Override
    public int operate(int fistNumber, int secondNumber) {
        if (secondNumber <= 0 || fistNumber % secondNumber != 0) {
            throw new IllegalArgumentException("나눗셈을 진행할 수 없습니다.");
        }
        return fistNumber / secondNumber;
    }
}
