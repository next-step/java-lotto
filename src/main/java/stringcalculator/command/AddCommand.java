package stringcalculator.command;

import stringcalculator.domain.Number;

public class AddCommand implements Command {

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.add(rightNumber);
    }

    @Override
    public String toString() {
        return "연산: +";
    }
}
