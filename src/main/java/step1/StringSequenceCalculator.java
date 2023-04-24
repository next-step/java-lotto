package step1;

public class StringSequenceCalculator {
    private final NumberParser numberParser;
    private final OperatorParser operatorParser;

    public StringSequenceCalculator() {
        this.numberParser = new NumberParser();
        this.operatorParser = new OperatorParser();
    }

    public int calculate(Expression expression) {
        final Numbers numbers = numberParser.parse(expression);
        final Operators operators = operatorParser.parse(expression);

        int result = numbers.getFirstNumber();
        for (int i = 0; i < operators.length(); i++) {
            result = calculate(result, numbers.getFromIndex(i + 1), operators.getFromIndex(i));
        }
        return result;
    }

    private int calculate(int num1, int num2, Operator operator) {
        return operator.calculate(num1, num2);
    }
}
