package step1.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).isDivision() && operands.get(i + 1).getValue() == 0) {
                throw new IllegalArgumentException("나누기 연산에서 0을 사용할 수 없습니다.");
            }
        }
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
