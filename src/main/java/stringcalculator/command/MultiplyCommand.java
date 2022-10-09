package stringcalculator.command;

import stringcalculator.domain.Number;

public class MultiplyCommand implements Command {

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.multiply(rightNumber);
    }

    @Override
    public String toString() {
        return "연산: *";
    }
}
