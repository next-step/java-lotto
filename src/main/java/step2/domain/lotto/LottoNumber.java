package step2.domain.lotto;

import step2.exception.InvalidNumberInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final List<LottoNumber> CACHE;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int START_INCLUSIVE = 0;
    private static final int END_EXCLUSIVE = 46;

    private final int lottoNumber;

    static {
        CACHE = IntStream
                .range(START_INCLUSIVE, END_EXCLUSIVE)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static final LottoNumber valueOf(String lottoNumber) {
        return valueOf(Integer.valueOf(lottoNumber));
    }

    public static final LottoNumber valueOf(int lottoNumber) {
        validate(lottoNumber);
        return CACHE.get(lottoNumber);
    }

    private static final void validate(int lottoNumber) {
        if (lottoNumber < LOWER_BOUND || lottoNumber > UPPER_BOUND) {
            throw new InvalidNumberInputException();
        }
    }

    public static final List<LottoNumber> values() {
        return new ArrayList<>(CACHE.subList(LOWER_BOUND, END_EXCLUSIVE));
    }

    public final int getLottoNumber() {
        return lottoNumber;
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
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
