package lotto.domain;

import java.util.*;

public class LottoNumber {
    private static final String EXCEP_INVALID_LOTTO_NUM = "유효한 로또 범위를 넘었습니다.";
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static Map<Integer, LottoNumber> numberMap = new HashMap<>(MAX_LOTTO_NUM);
    private final int number;

    static {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
             numberMap.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    static void checkValidLottoNumber(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(EXCEP_INVALID_LOTTO_NUM);
        }
    }

    static public LottoNumber of(String number) {
        return of(Integer.parseInt(number));
    }

    static public LottoNumber of(int number) {
        checkValidLottoNumber(number);
        return numberMap.get(number);
    }

    @Override
    public String toString() {
        return String.format("%d", number);
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
