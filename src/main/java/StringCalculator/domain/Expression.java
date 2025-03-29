package StringCalculator.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    private final List<Operator> operators;
    private final List<Operand> operands;

    public Expression(String input) {
        this.operators = getOperators(input);
        this.operands = getOperands(input);
        validateDivisionByZero();
    }

    public static List<Operand> getOperands(String expression) {
        return Arrays.stream(expression.split("[^0-9]+"))
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .map(Operand::new)
                .collect(Collectors.toList());
    }

    public static List<Operator> getOperators(String expression) {
        return Arrays.stream(expression.split("[ 0-9]+"))
                .filter(token -> !token.isEmpty())
                .map(String::trim)
                .map(Operator::new)
                .collect(Collectors.toList());
    }

    private void validateDivisionByZero() {
        if (IntStream.range(0, operators.size())
                .anyMatch(this::isDivisionByZero)) {
            throw new IllegalArgumentException("나누기 연산에서 0을 사용할 수 없습니다.");
        }
    }

    private boolean isDivisionByZero(int index) {
        return operators.get(index).isDivision() && operands.get(index + 1).getValue() == 0;
    }

    public static boolean isInvalidInputFormat(String input) {
        if (input == null || input.isBlank() || input.trim().isEmpty()) {
            return false;
        }
        return !input.matches("^[0-9]+( [\\+\\-\\*/] [0-9]+)*$");
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
