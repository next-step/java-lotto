package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private final List<Integer> winnerNumbers;

    public WinnerNumber(String winnerNumber) {
        this.winnerNumbers = createWinnerNumber(winnerNumber);
    }

    public WinnerNumber(List<Integer> winnerNumber) {
        this.winnerNumbers = winnerNumber;
    }

    private List<Integer> createWinnerNumber(String winnerNumber) {
        List<Integer> result = stringToList(winnerNumber).stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        if (isDuplicateNumbers(result)) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_DUPLICATE_ERROR);
        }

        if (isWinnerNumberCount(result)) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_COUNT_ERROR);
        }

        if (isWinnerNumbers(result)) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_SIZE_ERROR);
        }

        return result;
    }

    private boolean isWinnerNumberCount(List<Integer> result) {
        return result.size() != LottoConstant.LOTTO_NUMBER_COUNT;
    }

    private boolean isDuplicateNumbers(List<Integer> result) {
        return result.stream()
                .distinct()
                .count() != LottoConstant.LOTTO_NUMBER_COUNT;
    }

    private boolean isWinnerNumbers(List<Integer> result) {
        return result.stream()
                .anyMatch(this::isLottoNumberSize);
    }

    private boolean isLottoNumberSize(int number) {
        return (LOTTO_MIN_NUMBER > number)
                || (LOTTO_MAX_NUMBER < number);
    }

    private List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Integer> readOnlyWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }

    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(winnerNumbers, numbers);
    }
}
