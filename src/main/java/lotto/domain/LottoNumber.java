package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final String INVALID_LOTTO_NUMBER_MSG = "로또 번호는 1이상 45이하 여야 합니다.";
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i ++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumberMap.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_MSG);
        }

        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
