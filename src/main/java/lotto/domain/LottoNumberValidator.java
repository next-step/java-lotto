package lotto.domain;

import java.util.List;

public class LottoNumberValidator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    public static boolean isInvalidLottoNumberBound(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch((number) -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
    }

    public static boolean inInvalidLottoNumberSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_SIZE;
    }
}
