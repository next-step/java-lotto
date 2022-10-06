package stringcalculator.command;

import stringcalculator.Number;

@FunctionalInterface
public interface Command {
    Number execute(Number leftNumber, Number rightNumber);
}
