package step1.domain.operator;

public class MultiplicationOperator implements Operator {

    @Override
    public int operate(int fistNumber, int secondNumber) {
        return fistNumber * secondNumber;
    }
}
