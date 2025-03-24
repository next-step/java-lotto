import java.util.ArrayList;
import java.util.List;

public class Expression {
    private static final String DELIMITER = " ";
    private final List<Operator> operators;
    private final List<Integer> numbers;

    public Expression(List<Operator> operators, List<Integer> numbers) {
        this.operators = operators;
        this.numbers = numbers;
    }

    public static Expression createExpression(String expression) {
        checkValidExpression(expression);
        List<Operator> operators = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        String[] tokens = split(expression, DELIMITER);
        for (int index = 0; index < tokens.length - 1; index += 2) {
            numbers.add(toInt(tokens[index]));
            operators.add(Operator.of(tokens[index + 1]));
        }
        numbers.add(toInt(tokens[tokens.length - 1]));

        return new Expression(operators, numbers);
    }

    private static void checkValidExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("null or empty expression");
        }
    }

    public Operator getCurrentOperator(int index) {
        return operators.get(index);
    }

    public int getCurrentNumber(int index) {
        return numbers.get(index);
    }

    public int getOperatorSize() {
        return operators.size();
    }

    private static String[] split(String input, String delimiter){
        return input.split(delimiter);
    }

    private static int toInt(String input){
        return Integer.parseInt(input);
    }
}
