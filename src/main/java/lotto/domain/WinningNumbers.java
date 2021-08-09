package lotto.domain;

import lotto.exception.InvalidWinningNumDuplicateException;
import lotto.exception.InvalidWinningNumLengthException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.StringUtil.split;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validNumbersLength(winningNumbers);
        validNumbersDuplicate(winningNumbers);
        this.winningNumbers = Arrays.stream(split(winningNumbers))
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    private void validNumbersLength(String winningNumbers) {
        if (split(winningNumbers).length != 6) {
            throw new InvalidWinningNumLengthException();
        }
    }

    private void validNumbersDuplicate(String winningNumbers) {
        String[] split = split(winningNumbers);
        boolean duplicate = Arrays.stream(split(winningNumbers))
                .map(Integer::valueOf)
                .distinct()
                .count() != split.length;
        if (duplicate) {
            throw new InvalidWinningNumDuplicateException();
        }
    }
}
