package lotto.step2.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public int matchWinningNumber(Lotto lotto) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if(lotto.hasNumber(winningNumber)) matchCount++;
        }
        return matchCount;

    }
}
