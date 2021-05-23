package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> numberCache = new HashMap<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numberCache.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return numberCache.get(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 " + MIN_LOTTO_NUMBER + "과 " + MAX_LOTTO_NUMBER + "사이의 정수 이어야 합니다.");
        }
    }

    public int number() {
        return number;
    }
}
