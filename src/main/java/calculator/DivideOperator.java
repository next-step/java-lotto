package calculator;

import java.util.function.IntBinaryOperator;

public class DivideOperator implements Operator {

    private static DivideOperator divideCalculator;

    private DivideOperator() {
    }

    public static Operator getInstance() {
        if (divideCalculator == null) {
            divideCalculator = new DivideOperator();
        }
        return divideCalculator;
    }

    @Override
    public IntBinaryOperator operate() {
        return (firstNumber, secondNumber) -> {
            if (secondNumber == 0) {
                throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
            }
            return firstNumber / secondNumber;
        };
    }

}

