package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;
    private final static Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(final int number) {
        if (validateNumber(number)) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.");
        }
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        if (LOTTO_NUMBER_CACHE.get(number) == null) {
            LOTTO_NUMBER_CACHE.put(number, new LottoNumber(number));
        }
        return LOTTO_NUMBER_CACHE.get(number);
    }

    private int getNumber() {
        return number;
    }

    public boolean hasNumber(int number) {
        return this.number == number;
    }

    private boolean validateNumber(int number) {
        return number < 1 || number > 45;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.getNumber(), o.getNumber());
    }
}
