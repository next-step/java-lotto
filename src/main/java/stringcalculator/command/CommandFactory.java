package stringcalculator.command;

import java.util.Set;

import stringcalculator.command.AddCommand;
import stringcalculator.command.Command;
import stringcalculator.command.DivideCommand;
import stringcalculator.command.MinusCommand;
import stringcalculator.command.MultiplyCommand;

public class CommandFactory {
    private static final Set<String> SUPPORTED_OPERATORS = Set.of("+", "-", "*", "/");

    public Command getCommand(String operator) {
        if (!SUPPORTED_OPERATORS.contains(operator)) {
            throw new IllegalArgumentException();
        }

        if (operator.equalsIgnoreCase("+")) {
            return new AddCommand();
        } else if (operator.equalsIgnoreCase("-")) {
            return new MinusCommand();
        } else if (operator.equalsIgnoreCase("*")) {
            return new MultiplyCommand();
        } else {
            return new DivideCommand();
        }
    }
}
