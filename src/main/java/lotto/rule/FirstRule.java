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
        return lotto.howManyContain(winningNumber) == 6;
    }

    @Override
    public String getDescription() {
        return "6개 일치";
    }
}
