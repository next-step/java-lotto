package study;

import java.util.Arrays;
import java.util.Optional;

public enum FourOperation {
    PLUS("+") {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    };

    private final String sign;

    FourOperation(String sign) {
        this.sign = sign;
    }

    public static FourOperation findBySign(String sign) {

        return Arrays.stream(FourOperation.values())
                .filter(fourOperation -> fourOperation.sign.equals(sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호를 입력해주세요."));
    }

    public abstract int apply(int x, int y);

}
