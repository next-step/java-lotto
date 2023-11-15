package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 3등 규칙 판정
 */
public class ThirdRule implements WinningRule {
    private ThirdRule() {
    }

    public static ThirdRule getInstance() {
        return new ThirdRule();
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber.toList()) == 5;
    }

    @Override
    public WinningLevel getRank() {
        return WinningLevel.THIRD;
    }
}
