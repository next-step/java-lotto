package domain;

import exception.InvalidRangeNumberException;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER_BOUND = 1;
    public static final int MAX_NUMBER_BOUND = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers = IntStream.rangeClosed(MIN_NUMBER_BOUND, MAX_NUMBER_BOUND)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::getValue, Function.identity()));

    public int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        validate(lottoNumber);
        return lottoNumbers.get(lottoNumber);
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER_BOUND || lottoNumber > MAX_NUMBER_BOUND) {
            throw new InvalidRangeNumberException();
        }
    }

    public int getValue() {
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
        return Integer.compare(lottoNumber, o.getValue());
    }
}
