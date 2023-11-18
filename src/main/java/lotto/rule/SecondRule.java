package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

public class SecondRule implements WinningRule {
    private static SecondRule instance;

    private SecondRule() {
    }

    public static SecondRule getInstance() {
        if (instance == null) {
            instance = new SecondRule();
        }

        return instance;
    }


    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        if (lotto.howManyContain(winningNumber) != 5) {
            return false;
        }

        return lotto.containBonusNumber(winningNumber);
    }

    @Override
    public WinningLevel getRank() {
        return WinningLevel.SECOND;
    }
}
