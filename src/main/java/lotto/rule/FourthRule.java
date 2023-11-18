package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 4등 규칙 판정
 */
public class FourthRule implements WinningRule {
    private static FourthRule instance;

    private FourthRule() {
    }

    public static FourthRule getInstance() {
        if (instance == null) {
            instance = new FourthRule();
        }

        return instance;
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber) == 4;
    }

    @Override
    public WinningLevel getRank() {
        return WinningLevel.FOURTH;
    }
}
