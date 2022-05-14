package lotto.domain;

import lotto.util.StringNumberUtils;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        for (int number = LOTTO_MIN_NUMBER; number <= LOTTO_MAX_NUMBER; number++) {
            lottoNumberCache.put(number, new LottoNumber(number));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static LottoNumber create(int number) {
        validateNumberRange(number);
        return lottoNumberCache.get(number);
    }

    public static LottoNumber create(String stringNumber) {
        return create(StringNumberUtils.parse(stringNumber));
    }

    private static void validateNumberRange(int number) {
        if (inValidNumberRange(number)) {
            throw new IllegalArgumentException(String.format("%d는 로또 숫자 범위(%d ~ %d)를 벗어났습니다.", number, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }

    private static boolean inValidNumberRange(int number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }

    public int getNumber() {
        return this.number;
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
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
