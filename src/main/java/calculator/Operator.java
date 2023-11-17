package calculator;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

        ADDITION("+", "더하기", (valueX, valueY) -> valueX + valueY),
        SUBTRACTION("-", "빼기", (valueX, valueY) -> valueX - valueY),
        MULTIPLICATION("*", "곱하기", (valueX, valueY) -> valueX * valueY),
        DIVISION("/", "나누기", (valueX, valueY) -> valueX / valueY);

        private static final Map<String, Operator> CODE_MAP =
            Stream.of(values()).collect(Collectors.toMap(Operator::code, operator -> operator));
        private final BiFunction<Integer, Integer, Integer> expression;
        private final String code;
        private final String description;

        Operator(String code, String description, BiFunction<Integer, Integer, Integer> expression) {
                this.code = code;
                this.description = description;
                this.expression = expression;
        }

        public String code() {
                return code;
        }

        public boolean isSameCode(String code) {
                return code.equals(this.code);
        }

        public static Operator valueOfCode(String code) {
                if (!CODE_MAP.containsKey(code)) {
                        throw new IllegalArgumentException("잘못된 사칙연산 기호를 입력하였습니다.");
                }
                return CODE_MAP.get(code);
        }

        public int apply(int valueX, int valueY) {
                if (this.isSameCode(DIVISION.code)) {
                        validateDivisionDenominator(valueY);
                }
                return expression.apply(valueX, valueY);
        }

        private void validateDivisionDenominator(int valueY) {
                if (valueY == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
        }

}
