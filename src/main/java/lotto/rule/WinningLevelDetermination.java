package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;

import java.util.List;

/**
 * 로또 번호와 당첨 번호 + 보너스 번호를 가지고 몇 등인지 판단하는 규칙 집합
 */
public class WinningLevelDetermination {
    private static final List<WinningRule> WINNING_RULES = List.of(
            FirstRule.getInstance(),
            SecondRule.getInstance(),
            ThirdRule.getInstance(),
            FourthRule.getInstance(),
            FifthRule.getInstance()
    );

    private WinningLevelDetermination() {
    }

    /**
     * 주어진 로또에 주어진 당첨번호를 적용했을 때 몇 등인지 계산합니다.
     *
     * @param lotto 로또 용지
     *
     * @return 이 로또의 당첨 등수
     */
    public static WinningLevel whatRank(Lotto lotto, WinningNumber winningNumber) {
        for (WinningRule rule : WINNING_RULES) {
            //TODO: 이 if문을 빼버리고 for문 하나로 이를 처리할 수 있을까요??
            if (rule.isMatched(lotto, winningNumber)) {
                return rule.getRank();
            }
        }

        return WinningLevel.NONE;
    }
}
