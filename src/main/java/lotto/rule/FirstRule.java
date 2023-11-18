package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 1등 규칙 판정
 */
public class FirstRule implements WinningRule {
    private static FirstRule instance;

    private FirstRule() {
    }

    public static FirstRule getInstance() {
        if (instance == null) {
            instance = new FirstRule();
        }

        return instance;
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber.toList()) == 6;
    }

    @Override
    public WinningLevel getRank() {
        return WinningLevel.FIRST;
    }
}
