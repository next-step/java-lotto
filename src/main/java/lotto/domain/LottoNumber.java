package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static lotto.utils.Constants.*;

public class LottoNumber {
    private final int lottoNumber;
    private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

    static {
        for (int i = NUMBER_ZERO; i <= NUMBER_FORTY_FIVE; i++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumberMap.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(MSG_LOTTO_NUMBER_ONE_TO_FORTY_FIVE);
        }
        return lottoNumber;
    }

    public static LottoNumber of(String lottoNumber) {
        return of(Integer.parseInt(lottoNumber));
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
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
