package lotto.view;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.view.vo.MatchResult;

import java.util.List;

public class OutputView {

    public static void generateResult(List<BasicLotto> lottos, WinningLotto winningLotto) {
        for (BasicLotto lotto : lottos) {
            int matchCount = winningLotto.checkMatchNumbers(lotto);
            calculateMatchCount(matchCount);
        }
    }

    private static void calculateMatchCount(int matchCount) {
        for (Rank rank : Rank.values()) {
            if (matchCount == rank.getCountOfMatch()) {
                MatchResult.addMatchCount(rank.getCountOfMatch());
            }
        }
    }

    public static String getRewardPercent(int money) {
        int reward = 0;

        for (Rank rank : Rank.values()) {
            reward += (rank.getWinningMoney() * MatchResult.getMatchCount(rank.getCountOfMatch()));
        }

        double percent = (double) reward / money;
        return String.format("%.2f", percent);
    }
}
