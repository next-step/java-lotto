package net.chandol.lotto.util;

import java.util.List;

public class LottoNumberValidator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateNumbersRange(List<Integer> numbers) {
        if (containsInvalidRange(numbers)) {
            throw new IllegalArgumentException("유효하지 않은 범위의 번호입니다.");
        }
    }

    public static boolean isInvalidLottoRange(int n) {
        return (n < LOTTO_MIN_NUMBER) || (n > LOTTO_MAX_NUMBER);
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

    private static boolean containsInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(LottoNumberValidator::isInvalidLottoRange);
    }

}
