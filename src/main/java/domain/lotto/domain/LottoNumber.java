package domain.lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber from(Random random) {
        return new LottoNumber(random.nextInt(45) + 1);
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

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
