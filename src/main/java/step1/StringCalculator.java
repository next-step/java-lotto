package step1;

import java.util.ArrayList;
import java.util.List;

import static step1.Expression.extractNodeList;
import static step1.Expression.extractOperatorList;

public class StringCalculator {

    public int calculate(String input) {
        if(input==null || input.isBlank() ) {
            throw new IllegalArgumentException();
        }
        List<String> inputArray = tokenize(input);
        Expression expression = new Expression(extractNodeList(inputArray), extractOperatorList(inputArray));
        return expression.execute();
    }

    private static List<String> tokenize(String input) {
        return List.of(input.split(" "));
    }
}
