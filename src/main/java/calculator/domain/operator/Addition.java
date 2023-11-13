package calculator.domain.operator;

public class Addition implements Operator {
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}
