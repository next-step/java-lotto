package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 5등 규칙 판정
 */
public class FifthRule implements WinningRule {
    private FifthRule() {
    }

    public static FifthRule getInstance() {
        return new FifthRule();
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber.toList()) == 3;
    }

    @Override
    public WinningLevel getRank() {
        return WinningLevel.FIFTH;
    }
}
