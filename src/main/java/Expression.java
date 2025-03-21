import java.util.ArrayList;
import java.util.List;

public class Expression {
    private static final String DELIMITER = " ";
    private List<Operator> operators;
    private List<Integer> numbers;

    public Expression(List<Operator> operators, List<Integer> numbers) {
        this.operators = operators;
        this.numbers = numbers;
    }

    public static Expression createExpression(String expression) {
        checkValidExpression(expression);
        List<Operator> operators = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        String[] tokens = Splitter.split(expression, DELIMITER);
        for (int index = 0; index < tokens.length - 1; index += 2) {
            numbers.add(StringParser.toInt(tokens[index]));
            operators.add(Operator.of(tokens[index + 1]));
        }
        numbers.add(StringParser.toInt(tokens[tokens.length - 1]));

        return new Expression(operators, numbers);
    }

    private static void checkValidExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("null or empty expression");
        }
    }
}
