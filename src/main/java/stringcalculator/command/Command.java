package stringcalculator.command;

import stringcalculator.domain.Number;

@FunctionalInterface
public interface Command {
    Number execute(Number leftNumber, Number rightNumber);
}
