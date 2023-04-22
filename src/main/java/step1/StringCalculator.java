package step1;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int calculate(String input) {
        if(input==null || input.isBlank() ) {
            throw new IllegalArgumentException();
        }
        String[] inputArray = tokenize(input);
        List<Node> nodeList = Expression.extractNodeList(inputArray);
        List<Operator> operatorList = Expression.extractOperatorList(inputArray);

        Expression expression = new Expression(nodeList, operatorList);
        return expression.execute();

    }

    private static String[] tokenize(String input) {
        String[] inputArray = input.split(" ");
        return inputArray;
    }
}
