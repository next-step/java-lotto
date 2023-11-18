package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 5등 규칙 판정
 */
public class FifthRule implements WinningRule {
    private static FifthRule instance;

    private FifthRule() {
    }

    public static FifthRule getInstance() {
        if (instance == null) {
            instance = new FifthRule();
        }

        return instance;
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber) == 3;
    }
}
