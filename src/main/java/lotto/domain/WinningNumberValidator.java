package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumberValidator {
    
    private final String INCORRECT_INPUT = "올바른 입력이 아닙니다.";
    
    public void validateWinningNumber(List<Integer> winningNumber) {
        int winningNumberLength = winningNumber.size();
        validateLength(winningNumberLength);
        Collections.sort(winningNumber);
        int prev = 0;
        for (Integer integer : winningNumber) {
            validateNumber(integer, prev);
            prev = integer;
        }
    }
    
    private void validateNumber(Integer integer, int prev) {
        validateDuplication(integer, prev);
        validateInRange(integer);
    }
    
    public void validateInRange(Integer integer) {
        if (integer < LottoRules.START_NUM) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
        if (integer > LottoRules.LAST_NUM) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
        
    }
    
    private void validateLength(int winningNumberLength) {
        if (winningNumberLength != LottoRules.LOTTO_COUNT) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
    }
    
    private void validateDuplication(Integer integer, int prev) {
        if (prev == integer) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
    }
    
}
