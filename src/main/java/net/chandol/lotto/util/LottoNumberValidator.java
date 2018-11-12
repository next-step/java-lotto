package net.chandol.lotto.util;

import java.util.List;

public class LottoNumberValidator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateNumbersRanges(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validateNumberRange);
    }

    public static void validateNumberRange(int n) {
        if ((n < LOTTO_MIN_NUMBER) || (n > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("유효하지 않은 범위의 번호입니다.");
        }
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        long count = getUniqueNumberCount(numbers);
        if (count != numbers.size()) {
            throw new IllegalArgumentException("중복번호가 존재합니다.");
        }
    }

    private static long getUniqueNumberCount(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

}
