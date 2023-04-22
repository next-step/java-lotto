package step1;

import java.util.List;

public class StringSequenceCalculator {
    private final NumberParser numberParser;
    private final OperatorParser operatorParser;

    public StringSequenceCalculator() {
        this.numberParser = new NumberParser();
        this.operatorParser = new OperatorParser();
    }

    public int calculate(String input) {
        final List<Integer> numbers = numberParser.parse(input);
        final List<Operator> operators = operatorParser.parse(input);

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = calculate(result, numbers.get(i + 1), operators.get(i));
        }
        return result;
    }

    private int calculate(int num1, int num2, Operator operator) {
        return operator.calculate(num1, num2);
    }
}
