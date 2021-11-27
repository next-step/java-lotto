package lotto.domain.value;

import lotto.exception.WinningNumberException;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private static final int NUMBERS_SIZE = 6;
    private List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public static WinningNumbers of(List<Integer> numbers) {
        validateSize(numbers);

        return new WinningNumbers(numbers);
    }

    private static void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBERS_SIZE) {
            throw new WinningNumberException();
        }
    }

}
