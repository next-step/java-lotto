package step2.util;

import step2.constant.LottoConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtil {
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 범위에 벗어난 값입니다.";
    private static final String INVALID_DIGIT_EXCEPTION_MESSAGE = "로또는 6자리 수가 입력되어야 합니다.";
    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "중복된 숫자가 존재합니다.";

    private ValidateUtil() {
    }

    public static void validate(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstant.END_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> duplicateNumbers = new HashSet(winningNumbers);
        if (duplicateNumbers.size() != LottoConstant.END_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < LottoConstant.MIN_LOTTO_NUMBER || lottoNumber > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new RuntimeException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
