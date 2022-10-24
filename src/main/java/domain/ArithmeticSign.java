package domain;

import java.util.Arrays;

public enum ArithmeticSign {
    PLUS("+"){
        @Override
        public Number doArithmetic(Number number1, Number number2) {
            return new Number(number1.getNumber() + number2.getNumber());
        }
    },
    MINUS("-"){
        @Override
        public Number doArithmetic(Number number1, Number number2) {
            return new Number(number1.getNumber() - number2.getNumber());
        }
    },
    MULTIPLICATION("*"){
        @Override
        public Number doArithmetic(Number number1, Number number2) {
            return new Number(number1.getNumber() * number2.getNumber());
        }
    },
    DIVISION("/"){
        @Override
        public Number doArithmetic(Number number1, Number number2) {
            if (number2.getNumber() == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            if (number1.getNumber() * 1.0 / number2.getNumber() % 1 != 0){
                throw new IllegalArgumentException("결과값이 정수가 아닙니다.");
            }
            return new Number(number1.getNumber() / number2.getNumber());
        }
    };

    private final String sign;
    public abstract Number doArithmetic(Number number1, Number number2);

    ArithmeticSign(String sign) {
        this.sign = sign;
    }

    public static ArithmeticSign of(String sign) {
        return Arrays.stream(values())
                .filter(v -> sign.equals(v.sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산에 해당하지 않는 기호식입니다."));
    }
}
