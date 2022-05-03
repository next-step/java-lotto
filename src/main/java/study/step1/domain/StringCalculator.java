package study.step1.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class StringCalculator {
    private static final String SPACE = " ";
    private final Formula formula;
    private Map<Character, Operator> operators = new HashMap<>();

    public StringCalculator(Formula formula) {
        for (Operator value : Operator.values()) {
            operators.put(value.operator, value);
        }
        this.formula = formula;
    }

    public int start() {
        String[] strArr = formula.getString().split(SPACE);
        int result = Integer.parseInt(strArr[0]);
        for (int i = 0; i < strArr.length - 2; i += 2) {
            result = run(strArr[i + 1].charAt(0), result, Integer.parseInt(strArr[i + 2]));
        }
        return result;
    }

    public int run(char operator, int num1 ,int num2) {
        return operators.get(operator).calculate(num1, num2);
    }

    enum Operator {
        PLUS('+', (n1, n2) -> n1 + n2),
        MINUS('-', (n1, n2) -> n1 - n2),
        MULT('*', (n1, n2) -> n1 * n2),
        DIVIDE('/', (n1, n2) -> n1 / n2);

        private char operator;
        private BiFunction<Integer, Integer, Integer> expression;

        Operator(char operator, BiFunction<Integer, Integer, Integer> expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public int calculate(int num1, int num2) {
            return this.expression.apply(num1, num2);
        }
    }
}
