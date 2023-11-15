package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 4등 규칙 판정
 */
public class FourthRule implements WinningRule {
    private FourthRule() {
    }

    public static FourthRule getInstance() {
        return new FourthRule();
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber.toList()) == 4;
    }

    @Override
    public WinningLevel getRank() {
        return WinningLevel.FOURTH;
    }
}
