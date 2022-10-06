package stringcalculator;

import java.util.Set;

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
