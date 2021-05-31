package lotto.domains;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();
    private final int number;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_NUMBER_MAP.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return LOTTO_NUMBER_MAP.get(number);
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1부터 45까지의 값을 입력해주세요");
        }
    }

    public int number() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(Object o) {
        return number;
    }
}
