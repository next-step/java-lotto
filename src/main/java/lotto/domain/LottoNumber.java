package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private final int number;
    private static final Map<Integer, LottoNumber> lottoRange = new HashMap<>();

    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;

    static {
        for (int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_MAXIMUM_NUMBER; i++) {
            lottoRange.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String number) {
        LottoNumber lottoNumber = lottoRange.get(Integer.parseInt(number));
        if (Objects.isNull(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 값만 가능합니다.");
        }
        return lottoNumber;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoRange.get(number);
        if (Objects.isNull(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 값만 가능합니다.");
        }
        return lottoNumber;
    }

    public String getNumberByString() {
        return String.valueOf(this.number);
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
}
