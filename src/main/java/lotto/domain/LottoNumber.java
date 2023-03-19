package lotto.domain;

import java.util.*;

public class LottoNumber {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자의 범위를 벗어났습니다.");
        }
        if (!isInitLottoNumbersMap()) {
            initializeLottoNumbers();
        }
        return lottoNumbers.get(number);
    }

    private static boolean isInitLottoNumbersMap() {
        return lottoNumbers.size() == (LOTTO_MAX_NUMBER - LOTTO_MIN_NUMBER + 1);
    }

    private static void initializeLottoNumbers() {
        for (int number = LOTTO_MIN_NUMBER; number <= LOTTO_MAX_NUMBER; number++) {
            lottoNumbers.put(number, new LottoNumber(number));
        }
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
        return Integer.toString(number);
    }
}
