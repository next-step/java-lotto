package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static Integer MIN_NUMBER = 1;
    private static Integer MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String numberValue) {
        this(Integer.parseInt(numberValue));
    }

    private void validate(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return;
        }

        throw new IllegalArgumentException("1 - 45 사이 숫자를 입력해주세요");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
