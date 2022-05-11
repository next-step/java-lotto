package study.step1.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Operator.of(operator).calculate(num1, num2);
    }

    enum Operator {
        PLUS("+", (n1, n2) -> n1 + n2),
        MINUS("-", (n1, n2) -> n1 - n2),
        MULT("*", (n1, n2) -> n1 * n2),
        DIVIDE("/", (n1, n2) -> n1 / n2);

        private static final String REGULAR_EXPRESSION = "^[+\\-*/\\d]*$";
        private static final String EXCEPTION_MESSAGE = "올바른 수식을 입력해주세요.";
        private static final Map<String, String> OPERATOR_MAP =
                Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Operator::getOperator, Operator::name)));

        private final String operator;
        private final ToIntBiFunction<Integer, Integer> expression;


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

        public static Operator of(final String operator) {
            isOperator(operator);
            return Operator.valueOf(OPERATOR_MAP.get(operator));
        }

        private static void isOperator(String operator) {
            if (!operator.matches(REGULAR_EXPRESSION)) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
