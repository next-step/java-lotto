package step1.domain.operator;

public class AdditionOperator implements Operator {

    @Override
    public int operate(int fistNumber, int secondNumber) {
        return fistNumber + secondNumber;
    }
}
