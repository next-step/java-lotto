package calculator;

import java.util.function.IntBinaryOperator;

public class AddOperator implements Operator {

    private static AddOperator addCalculator;

    private AddOperator() {
    }

    public static Operator getInstance() {
        if (addCalculator == null) {
            addCalculator = new AddOperator();
        }
        return addCalculator;
    }

    @Override
    public IntBinaryOperator operate() {
        return (firstNumber, secondNumber) -> firstNumber + secondNumber;
    }

}

