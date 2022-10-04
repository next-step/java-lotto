package calculator.domain;

import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-10-04
 */
public class CalculateResult {
    private int result;

    public CalculateResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public CalculateResult plus(InputValue inputValue) {
        return new CalculateResult(result + inputValue.toNumber());
    }

    public CalculateResult minus(InputValue inputValue) {
        return new CalculateResult(result - inputValue.toNumber());
    }

    public CalculateResult multiple(InputValue inputValue) {
        return new CalculateResult(result * inputValue.toNumber());
    }

    public CalculateResult divide(InputValue inputValue) {
        if (inputValue.isZero()) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }

        if (isNotDivisible(inputValue)) {
            throw new IllegalArgumentException("나누어 떨어지지 않는 수 입니다.");
        }

        return new CalculateResult(result / inputValue.toNumber());
    }

    private boolean isNotDivisible(InputValue inputValue) {
        return result % inputValue.toNumber() != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculateResult that = (CalculateResult) o;
        return result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "CalculateResult{" +
                "result=" + result +
                '}';
    }
}
