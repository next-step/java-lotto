package lotto.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lotto.error.ErrorMessage;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> NUMBERS = new HashMap<>();
    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(NUMBERS.get(number))
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER));
    }

    public int getNumber() {
        return number;
    }
}