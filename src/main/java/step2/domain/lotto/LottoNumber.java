package step2.domain.lotto;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return String.valueOf(number);
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
}
