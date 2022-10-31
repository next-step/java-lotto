package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || 45 < lottoNumber) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하이어야 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        if (lottoNumber < 1 || 45 < lottoNumber) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하이어야 합니다.");
        }
        return lottoNumbers.get(lottoNumber);
    }

    public int getLottoNumber() {
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

}
