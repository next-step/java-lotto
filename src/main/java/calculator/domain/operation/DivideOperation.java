package calculator.domain.operation;

import calculator.exception.DivisionException;
import calculator.exception.InvalidOutputIntegerException;

public class DivideOperation implements Operation {

    @Override
    public int operate(int targetNumber, int number) {
        if (number == 0) {
            throw new DivisionException();
        }

        if (targetNumber % number > 0) {
            throw new InvalidOutputIntegerException();
        }

        return targetNumber / number;
    }
}
