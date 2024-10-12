package calculator.domain;

public enum OperatorType {
    PLUS {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.plus(second);
        }
    },
    MINUS {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.minus(second);
        }
    },
    TIMES {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.multiply(second);
        }
    },
    DIVISION {
        @Override
        public OperandNumber execute(OperandNumber first, OperandNumber second) {
            return first.divide(second);
        }
    };

    public static OperatorType from(String strValue) {
        if ("+".equals(strValue)) {
            return PLUS;
        }
        if ("-".equals(strValue)) {
            return MINUS;
        }
        if ("*".equals(strValue)) {
            return TIMES;
        }
        if ("/".equals(strValue)) {
            return DIVISION;
        }
        throw new IllegalArgumentException(String.format("해당 값 '%s'은 사칙 연산자에 해당하지 않습니다.", strValue));
    }

    public abstract OperandNumber execute(OperandNumber first, OperandNumber second);
}
