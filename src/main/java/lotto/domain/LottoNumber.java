package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
    private final int lottoNumber;

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER)
                .forEach(i -> lottoNumbers.add(new LottoNumber(i)));
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber get(int number) {
        return lottoNumbers.stream()
                .filter(num -> num.lottoNumber == number)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Set<LottoNumber> toSet() {
        return lottoNumbers;
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
}
