package calculator;

import java.util.function.IntBinaryOperator;

public class MultiplyOperator implements Operator {

    private static MultiplyOperator multiplyCalculator;

    private MultiplyOperator() {
    }

    public static Operator getInstance() {
        if (multiplyCalculator == null) {
            multiplyCalculator = new MultiplyOperator();
        }
        return multiplyCalculator;
    }

    @Override
    public IntBinaryOperator operate() {
        return (firstNumber, secondNumber) -> firstNumber * secondNumber;
    }

}

