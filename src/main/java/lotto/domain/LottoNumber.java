package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (!isValid(lottoNumber)) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber));
    }

    private boolean isValid(final int lottoNumber) {
        return lottoNumber >= START_LOTTO_NUMBER && lottoNumber <= END_LOTTO_NUMBER;
    }

    public static List<LottoNumber> getLottoNumberCollection() {
        return IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
