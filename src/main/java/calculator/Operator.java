package calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+") {
        @Override
        public Integer perform(Integer left, Integer right) {
            return left + right;
        }
    },
    SUBTRACT("-") {
        @Override
        public Integer perform(Integer left, Integer right) {
            return left - right;
        }
    },
    MULTIPLY("*") {
        @Override
        public Integer perform(Integer left, Integer right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public Integer perform(Integer left, Integer right) {
            return left / right;
        }
    };

    private static final Map<String, Operator> operatorSignMap = getOperatorSignMap();
    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    private static Map<String, Operator> getOperatorSignMap() {
        return Arrays.stream(Operator.values())
                .collect(Collectors.toMap(operator -> operator.sign, operator -> operator));
    }

    public static Operator fromSign(String sign) {
        return operatorSignMap.get(sign);
    }

    public abstract Integer perform(Integer left, Integer right);
}
