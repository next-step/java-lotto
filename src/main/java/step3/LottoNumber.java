package step3;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int inputNumber) {
        validate(inputNumber);
        this.number = inputNumber;
    }

    private void validate(int inputNumber) {
        int maxNumber = 45;
        int minNumber = 1;
        if (inputNumber < minNumber || inputNumber > maxNumber) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자로 구성되어 있어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
