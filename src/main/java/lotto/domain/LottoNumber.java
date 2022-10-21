package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-10-21
 */
public class LottoNumber {

    public static final int MAX = 45;
    public static final int MIN = 1;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력가능 합니다");
        }

        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = LOTTO_NUMBER_CACHE.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("1 ~ 45 값만 입력가능합니다");
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
}
