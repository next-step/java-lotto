package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private int lottoNumber;

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber of(int lottoNumber) {
        validLottoNumberRange(lottoNumber);
        return lottoNumbers.get(lottoNumber);
    }

    private static void validLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 범위는 1~45의 범위를 가짐");
        }
    }

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
