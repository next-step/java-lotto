package lotto.model;

import java.util.*;

import static lotto.model.WinningNumber.LOTTO_END_NUMBER;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber number(int number) {
        return getNumber.cache.get(number);
    }

    public static Map<Integer, LottoNumber> cache() {
        return getNumber.cache;
    }

    private static class getNumber {
        private static final Map<Integer, LottoNumber> cache = new HashMap<>();

        static {
            for (int i = 0; i < LOTTO_END_NUMBER; i++) {
                cache.put(i + 1, new LottoNumber(i + 1));
            }
        }
    }

    boolean isWinningNumber(String winNums) {
        return Integer.parseInt(winNums) == this.number;
    }

    public int getNumber() {
        return number;
    }
}
