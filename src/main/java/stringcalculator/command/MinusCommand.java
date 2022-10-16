package stringcalculator.command;

import stringcalculator.domain.Number;

public class MinusCommand implements Command {
    private static final String OPERATOR = "-";

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.minus(rightNumber);
    }

    @Override
    public String toString() {
        return OPERATOR;
    }

    @Override
    public String operator() {
        return OPERATOR;
    }
}
