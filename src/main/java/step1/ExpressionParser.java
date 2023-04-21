package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {

    private static final String INPUT_DELIMITER = " ";
    private static final String OPERAND_FORMAT = "\\d+";
    private static final String OPERATOR_FORMAT = "[+\\-*/]";

    public static Expression parse(UserInput userInput) {
        String[] splitInput = userInput.getInput().split(INPUT_DELIMITER);

        return Expression.from(getOperands(splitInput), getOperators(splitInput));
    }

    private static List<String> getOperands(String[] splitInput) {
        return Arrays.stream(splitInput)
                .filter(ExpressionParser::isOperand)
                .collect(Collectors.toList());
    }

    private static boolean isOperand(String value) {
        return value.matches(OPERAND_FORMAT);
    }

    private static List<String> getOperators(String[] splitInput) {
        return Arrays.stream(splitInput)
                .filter(ExpressionParser::isOperator)
                .collect(Collectors.toList());
    }

    private static boolean isOperator(String value) {
        return value.matches(OPERATOR_FORMAT);
    }
}
