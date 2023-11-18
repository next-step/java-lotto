package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 3등 규칙 판정
 */
public class ThirdRule implements WinningRule {
    private static ThirdRule instance;

    private ThirdRule() {
    }

    public static ThirdRule getInstance() {
        if (instance == null) {
            instance = new ThirdRule();
        }

        return instance;
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        if (lotto.howManyContain(winningNumber) != 5) {
            return false;
        }

        if (lotto.containBonusNumber(winningNumber)) {
            return false;
        }

        return true;
    }
}
