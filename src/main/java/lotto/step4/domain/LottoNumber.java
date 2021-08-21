package lotto.step4.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private int lottoNumber;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        lottoNumber = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 숫자는 " + LOTTO_MIN_NUMBER + "~" + LOTTO_MAX_NUMBER + "만 가능합니다.");
        }
        return lottoNumber;
    }

    public static LottoNumber of(String number) {
        return of(Integer.valueOf(number));
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
