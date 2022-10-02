package calculator;

import java.util.function.IntBinaryOperator;

public class SubstractOperator implements Operator {

    private static SubstractOperator substracCalculator;

    private SubstractOperator() {
    }

    public static Operator getInstance() {
        if (substracCalculator == null) {
            substracCalculator = new SubstractOperator();
        }
        return substracCalculator;
    }

    @Override
    public IntBinaryOperator operate() {
        return (firstNumber, secondNumber) -> firstNumber - secondNumber;
    }

}
