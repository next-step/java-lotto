package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static final int WINNING_NUMBERS_FIXED_AMOUNT = 6;
    private static final String WINNING_NUMBERS_ERROR_MESSAGE = "당첨 번호는 6개입니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_MESSAGE = "중복된 당첨번호입니다.";

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumber(List<String> winningNumbersInput, LottoNumber bonusBall) {
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
        if (winningNumbers.contains(new LottoNumber(winningNumber))) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_MESSAGE);
        }
    }

    private void parseStringToInt(List<String> winningNumbersInput) {
        for (int i = 0; i < winningNumbersInput.size(); i++) {
            int parsedWinningNumber=Integer.parseInt(winningNumbersInput.get(i));
            checkDuplicateWinningNumber(parsedWinningNumber);
            winningNumbers.add(new LottoNumber(parsedWinningNumber));
        }
    }

    public int findMatchingCount(List<LottoNumber> lotto) {
        int matchingResult = 0;
        for (LottoNumber winningNumber: winningNumbers) {
            matchingResult = countMatchingNumber(winningNumber, matchingResult, lotto);
        }
        return matchingResult;
    }

    private int countMatchingNumber(LottoNumber winningNumber, int count, List<LottoNumber> lotto) {
        if (lotto.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    public boolean isContainBonusBall(List<LottoNumber> lotto) {
        return lotto.contains(bonusBall);
    }

}
