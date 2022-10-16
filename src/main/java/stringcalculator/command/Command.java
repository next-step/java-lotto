package stringcalculator.command;

import stringcalculator.domain.Number;

public interface Command {
    Number execute(Number leftNumber, Number rightNumber);

    String operator();
}
