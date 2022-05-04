package study.step1.domain;

import java.util.function.ToIntBiFunction;

public class StringCalculator {
    private static final String SPACE = " ";
    private final Formula formula;

    public StringCalculator(Formula formula) {
        this.formula = formula;
    }

    public int start() {
        String[] strArr = formula.getString().split(SPACE);
        int result = Integer.parseInt(strArr[0]);
        for (int i = 0; i < strArr.length - 2; i += 2) {
            result = run(result, String.valueOf(strArr[i + 1].charAt(0)), Integer.parseInt(strArr[i + 2]));
        }
        return result;
    }

    public int run(int num1, String operator, int num2) {
        int result = 0;
        for (Operator value : Operator.values()) {
            if (operator.equals(value.getOperator())) {
                result = Operator.valueOf(value.name()).calculate(num1, num2);
            }
        }
        return result;
    }

    enum Operator {
        PLUS("+", (n1, n2) -> n1 + n2),
        MINUS("-", (n1, n2) -> n1 - n2),
        MULT("*", (n1, n2) -> n1 * n2),
        DIVIDE("/", (n1, n2) -> n1 / n2);

        private String operator;
        private ToIntBiFunction<Integer, Integer> expression;

        Operator(String operator, ToIntBiFunction<Integer, Integer> expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public String getOperator() {
            return operator;
        }

        public int calculate(int num1, int num2) {
            return expression.applyAsInt(num1, num2);
        }
    }
}
