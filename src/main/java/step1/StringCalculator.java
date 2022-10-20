package step1;

import java.util.List;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException("no input");
        }

        List<Pair<Operator, Integer>> tokenPairs = ExpressionParser.tokenize(input);

        int number = 0;
        for (Pair<Operator, Integer> tokenPair : tokenPairs) {
            Operator operator = tokenPair.first();
            Integer operand = tokenPair.second();
            number = operator.cal(number, operand);
        }

        return number;
    }
}
