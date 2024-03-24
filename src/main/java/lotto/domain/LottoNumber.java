package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(String.format("%d부터 %d 사이의 정확한 숫자를 입력해주세요", MIN, MAX));
        }
        this.number = number;
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
