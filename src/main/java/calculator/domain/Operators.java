package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Operators {

    private final List<Operator> operators = new ArrayList<>();

    public Operators(String[] inputs) {
        int i = 0;
        for (String o : inputs) {
            addOperator(i, o);
            ++i;
        }
    }

    public List<Operator> operators() {
        return this.operators;
    }

    private void addOperator(int i, String o) {
        if (i % 2 != 0) {
            Operator operator = Operator.match(o);
            this.operators.add(operator);
        }
    }

    public enum Operator {
        SUM("+", (num1, num2) -> num1 + num2),
        SUBTRACTION("-", (num1, num2) -> num1 - num2),
        MULTIPLICATION("*", (num1, num2) -> num1 * num2),
        division("/", (num1, num2) -> num1 / num2);

        private final String operator;

        private final BiFunction<Integer, Integer, Integer> expression;

        Operator(
            String operator,
            BiFunction<Integer, Integer, Integer> expression
        ) {
            this.operator = operator;
            this.expression = expression;
        }

        private static Operator match(String operator) {
            return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
        }

        public int calculate(int num1, int num2) {
            return this.expression.apply(num1, num2);
        }
    }
}
