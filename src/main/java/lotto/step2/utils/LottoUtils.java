package lotto.step2.utils;

import lotto.step2.exception.LottoException;

import java.util.Set;

public class LottoUtils {

    private static final String LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_MADE_OF_NUMBERS = 6;

    private LottoUtils() {
    }

    public static void validation(final Set<Integer> numbers) {
        if (numbers.size() != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }
    }
}
