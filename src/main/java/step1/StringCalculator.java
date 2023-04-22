package step1;

import java.util.List;

import static step1.Expression.extractNodes;
import static step1.Expression.extractOperators;

public class StringCalculator {

    public int calculate(String input) {
        validate(input);
        List<String> inputArray = tokenize(input);
        Expression expression = new Expression(extractNodes(inputArray), extractOperators(inputArray));
        return expression.execute();
    }

    private static void validate(String input) {
        if(input ==null || input.isBlank() ) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> tokenize(String input) {
        return List.of(input.split(" "));
    }
}
