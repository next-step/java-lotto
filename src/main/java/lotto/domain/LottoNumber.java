package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private int value;

    public LottoNumber(int value) {
        if (!lottoRange().contains(value)) {
            throw new IllegalArgumentException("1-45 범위를 벗어나는 로또 숫자가 입력되었습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static List<Integer> lottoRange() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value);
    }
}
