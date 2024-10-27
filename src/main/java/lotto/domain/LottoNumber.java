package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBER_LOWER_LIMIT;
import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBER_UPPER_LIMIT;

public class LottoNumber {
    private final int lottoNumber;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = LOTTO_NUMBER_LOWER_LIMIT; i <= LOTTO_NUMBER_UPPER_LIMIT; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(String.format("로또번호는 %d~%d 사이의 숫자만 가능합니다", LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT));
        }
        return lottoNumber;
    }

    public Integer getLottoNumber() {
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
        return Objects.hashCode(lottoNumber);
    }
}
