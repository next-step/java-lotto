package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumberPackage = new HashMap<>();
    private int lottoNumber;

    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNumberPackage.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        if (lottoNumber > LOTTO_END_NUMBER || lottoNumber < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException("번호형식이 틀렸습니다.");
        }
        return lottoNumberPackage.get(lottoNumber);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.lottoNumber);
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
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
