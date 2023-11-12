package step1.domain.operator;

public class MultiplyOperator implements Operator {

    @Override
    public int operate(int fistNumber, int secondNumber) {
        return fistNumber * secondNumber;
    }
}
