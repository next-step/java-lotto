package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int i) {
        this.number = validate(i);
    }

    private int validate(int i) {
        if (i > 0 && i < 46) {
            return i;
        }
        throw new IllegalArgumentException("로또 숫자는 1-45 사이로 입력해야 합니다");
    }

    public int exist(List<Integer> list) {
        return Collections.frequency(list, number);
    }

    public boolean same(int compareNumber) {
        return number == compareNumber;
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
        return String.valueOf(number);
    }
}
