package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumber {
    private final List<Integer> winnerNumbers;

    public WinnerNumber(String winnerNumber) {
        this.winnerNumbers = createWinnerNumber(winnerNumber);
    }

    private List<Integer> createWinnerNumber(String winnerNumber) {
        List<Integer> result = Arrays.stream(stringToArray(winnerNumber))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (!isDuplicateNumbers(result)) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_DUPLICATE_ERROR);
        }

        if (!isWinnerNumbers(result)) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_SIZE_ERROR);
        };

        return result;
    }

    public static boolean isDuplicateNumbers(List<Integer> result) {
        return result.stream()
                .distinct()
                .count() != LottoConstant.LOTTO_NUMBER_COUNT;
    }

    public static boolean isWinnerNumbers(List<Integer> result) {
        return result.stream()
                .anyMatch(WinnerNumber::isLottoNumberSize);
    }

    public static boolean isLottoNumberSize(int number) {
        return (LottoConstant.LOTTO_MIN_NUMBER > number)
                || (LottoConstant.LOTTO_MAX_NUMBER < number);
    }

    private String[] stringToArray(String winnerNumbers) {
        return winnerNumbers.split(",");
    }

    public List<Integer> getReadOnlyWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }
}
