package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNo {

    private final int number;

    LottoNo(final int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    boolean contains(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number == getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
