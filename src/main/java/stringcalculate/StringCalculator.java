package stringcalculate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class StringCalculator {
    private final List<String> expression;

    public StringCalculator(InputValue inputValue) {
        this.expression = inputValue.getExpression();
    }

    public int calculate() {
        return IntStream.iterate(0, i -> i + 2)
                .limit(expression.size() / 2)
                .reduce(parseInt(expression.get(0)), calculateExpression());
    }

    private IntBinaryOperator calculateExpression() {
        return (result, index) ->
                Operator.calculate(result, expression.get(index + 1), parseInt(expression.get(index + 2)));
    }

    private Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new WrongInputException("정수만 입력해주세요.");
        }
    }
}
