package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

/**
 * 미당첨 규칙 판정
 */
public class NoneRule implements WinningRule {
    private static NoneRule instance;

    private NoneRule() {
    }

    public static NoneRule getInstance() {
        if (instance == null) {
            instance = new NoneRule();
        }

        return instance;
    }

    @Override
    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.howManyContain(winningNumber) < 3;
    }

    @Override
    public String getDescription() {
        return "2개 이하 일치";
    }
}
