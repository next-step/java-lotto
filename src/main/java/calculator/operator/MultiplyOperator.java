package calculator.operator;

import calculator.operator.Calculable;

public class MultiplyOperator implements Calculable {
    @Override
    public int execute(int num1, int num2) {
        return num1 * num2;
    }
}
