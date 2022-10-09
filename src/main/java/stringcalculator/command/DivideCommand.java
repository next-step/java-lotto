package stringcalculator.command;

import stringcalculator.domain.Number;

public class DivideCommand implements Command {

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.divide(rightNumber);
    }

    @Override
    public String toString() {
        return "연산: /";
    }
}
