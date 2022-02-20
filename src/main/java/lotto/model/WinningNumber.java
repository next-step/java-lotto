package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final int WINNING_NUMBERS_FIXED_AMOUNT = 6;
    private static final String WINNING_NUMBERS_ERROR_MESSAGE = "당첨 번호는 6개입니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_MESSAGE = "중복된 당첨번호입니다.";
    private static final String BONUS_BALL_EXISTS_IN_WINNING_NUMBERS= "보너스볼이 이미 당첨번호에 있습니다";

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumber(List<Integer> winningNumbers, LottoNumber bonusBall) {
        validateWinningNumbers(winningNumbers);
        checkDuplicateWinningNumber(winningNumbers);
        this.winningNumbers =  winningNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        isBonusBallInWinningNumbers(bonusBall);
        this.bonusBall = bonusBall;
    }

    private void validateWinningNumbers(List<Integer> winningNumbersInput) {
        if (winningNumbersInput.size() != WINNING_NUMBERS_FIXED_AMOUNT) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void checkDuplicateWinningNumber(List<Integer> winningNumbers) {
        Set<Integer> checkSet = new HashSet<>(winningNumbers);
        if(checkSet.size()<winningNumbers.size()){
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_MESSAGE);
        }
    }

    private void isBonusBallInWinningNumbers(LottoNumber bonusBall){
        if(winningNumbers.contains(bonusBall)){
            throw new IllegalArgumentException(BONUS_BALL_EXISTS_IN_WINNING_NUMBERS);
        }
    }

    public int findMatchingCount(List<LottoNumber> lotto) {
        int matchingResult = 0;
        for (LottoNumber winningNumber : winningNumbers) {
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
