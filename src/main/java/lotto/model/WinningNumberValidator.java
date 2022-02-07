package lotto.model;

import java.util.Collections;
import java.util.List;

public class WinningNumberValidator {

    private final LottoRules lottoRules;
    private static final String INCORRECT_INPUT = "올바른 입력이 아닙니다.";

    WinningNumberValidator(LottoRules lottoRules) {
        this.lottoRules = lottoRules;
    }

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
        validateRange(integer);
    }

    private void validateRange(Integer integer) {
        if (integer < lottoRules.getStartNum()) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
        if (integer > lottoRules.getLastNum()) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
    }

    private void validateLength(int winningNumberLength) {
        if (winningNumberLength != lottoRules.getLottoCount()) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
    }

    private void validateDuplication(Integer integer, int prev) {
        if (prev == integer) {
            throw new RuntimeException(INCORRECT_INPUT);
        }
    }

}
