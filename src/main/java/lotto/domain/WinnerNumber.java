package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerNumber {
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
        };

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
        return (LottoConstant.LOTTO_MIN_NUMBER > number)
                || (LottoConstant.LOTTO_MAX_NUMBER < number);
    }

    private List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Integer> getReadOnlyWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerNumber that = (WinnerNumber) o;
        return Objects.equals(winnerNumbers, that.winnerNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers);
    }
}
