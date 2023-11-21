package step2;

import java.util.Objects;

public class Lotto {
    private final int number;

    public Lotto(int number) {
        checkNumber(number);
        this.number = number;
    }

    public int number() {
        return number;
    }

    private void checkNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return number == lotto.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
