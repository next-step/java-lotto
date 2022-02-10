package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static final int WINNING_NUMBERS_FIXED_AMOUNT = 6;
    private static final String WINNING_NUMBERS_ERROR_MESSAGE = "당첨 번호는 6개입니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_MESSAGE = "중복된 당첨번호입니다.";

    private final List<Integer> winningNumbers;
    private final int bonusBall;

    public WinningNumber(List<String> winningNumbersInput, int bonusBall) {
        winningNumbers = new ArrayList<>();
        validateWinningNumbers(winningNumbersInput);
        parseStringToInt(winningNumbersInput);
        this.bonusBall = bonusBall;
    }

    private void validateWinningNumbers(List<String> winningNumbersInput) {
        if (winningNumbersInput.size() != WINNING_NUMBERS_FIXED_AMOUNT) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void checkDuplicateWinningNumber(int winningNumber) {
        if (winningNumbers.contains(winningNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_MESSAGE);
        }
    }

    private void parseStringToInt(List<String> winningNumbersInput) {
        for (int i = 0; i < winningNumbersInput.size(); i++) {
            checkDuplicateWinningNumber(Integer.parseInt(winningNumbersInput.get(i)));
            winningNumbers.add(Integer.parseInt(winningNumbersInput.get(i)));
        }
    }

    public int findMatchingCount(List<Integer> lotto) {
        int matchingResult = 0;
        for (int winningNumber: winningNumbers) {
            matchingResult = countMatchingNumber(winningNumber, matchingResult, lotto);
        }
        return matchingResult;
    }

    private int countMatchingNumber(int winningNumber, int count, List<Integer> lotto) {
        if (lotto.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    public boolean isContainBonusBall(List<Integer> lotto) {
        return lotto.contains(bonusBall);
    }

}
