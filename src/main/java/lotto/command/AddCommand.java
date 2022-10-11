package lotto.command;

import lotto.domain.Number;

public class AddCommand implements Command {
    private static final String OPERATOR = "+";

    @Override
    public Number execute(Number leftNumber, Number rightNumber) {
        return leftNumber.add(rightNumber);
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
