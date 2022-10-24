package step3.domain;

import java.util.Objects;
import java.util.Optional;

public class LottoNumber implements Comparable<LottoNumber> {

    private int lottoNumber;
    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;

    private LottoNumber(int number) {
        validateLottoNumber(number);
        this.lottoNumber = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateLottoNumber(int number) {
        Optional.of(number)
            .filter(num -> num >= MIN_LOTTO_RANGE)
            .filter(num -> num <= MAX_LOTTO_RANGE)
            .orElseThrow(IllegalArgumentException::new);
    }

    public int getLottoNumber() {
        return lottoNumber;
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
