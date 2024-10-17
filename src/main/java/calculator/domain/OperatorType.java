package calculator.domain;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+") {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.plus(second);
        }
    },
    MINUS("-") {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.minus(second);
        }
    },
    TIMES("*") {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.multiply(second);
        }
    },
    DIVISION("/") {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.divide(second);
        }
    };

    private final String code;

    OperatorType(String code) {
        this.code = code;
    }

    public static OperatorType from(String strValue) {
        return Arrays.stream(values())
                .filter(value -> value.code.equals(strValue))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("연산자 '%s'에 해당하는 OperatorType이 존재하지 않습니다.", strValue)));
    }

    public abstract OperandNumber execute(OperandNumber first, OperandNumber second);
}
