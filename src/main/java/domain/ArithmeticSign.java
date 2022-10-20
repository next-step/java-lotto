package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArithmeticSign {

    private static final List<String> ARITHMETIC_SIGN = Arrays.asList("+", "-", "*", "/");
    String sign;

    public ArithmeticSign(String sign) {
        if (!ARITHMETIC_SIGN.contains(sign)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArithmeticSign that = (ArithmeticSign) o;
        return Objects.equals(sign, that.sign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign);
    }
}
