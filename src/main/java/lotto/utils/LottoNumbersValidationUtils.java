package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidationUtils {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String LOTTO_NUMBERS_SIZE_MUST_BE_EQUAL_TO_SIX = "로또 번호는 6개의 숫자로 구성되어야 합니다.";
    public static final String LOTTO_NUMBERS_MUST_BE_DISTINCT = "로또 번호들은 서로 다른 숫자여야만 한다.";

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateIfLottoNumbersSizeIsSix(lottoNumbers);
        validateIfHasDuplicateNumbers(lottoNumbers);
    }

    public static void validateIfLottoNumbersSizeIsSix(List<Integer> lottoNumbers) {
        if (isLottoNumbersSizeIsSix(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_MUST_BE_EQUAL_TO_SIX);
        }
    }

    private static boolean isLottoNumbersSizeIsSix(List<Integer> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_NUMBERS_SIZE;
    }

    public static void validateIfHasDuplicateNumbers(List<Integer> lottoNumbers) {
        if (hasDuplicateNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_BE_DISTINCT);
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);
        return lottoNumbersSet.size() != lottoNumbers.size();
    }
}
