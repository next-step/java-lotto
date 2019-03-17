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
            if (matchCount == Rank.FOURCE.getCountOfMatch()) {
                MatchResult.addMatchCount(Rank.FOURCE.getCountOfMatch());
            }
            if (matchCount == Rank.THIRD.getCountOfMatch()) {
                MatchResult.addMatchCount(Rank.THIRD.getCountOfMatch());
            }
            if (matchCount == Rank.SECOND.getCountOfMatch()) {
                MatchResult.addMatchCount(Rank.SECOND.getCountOfMatch());
            }
            if (matchCount == Rank.FIRST.getCountOfMatch()) {
                MatchResult.addMatchCount(Rank.FIRST.getCountOfMatch());
            }
        }
    }

    public static String getRewardPercent(int money) {
        int reward = 0;

        reward += (Rank.FOURCE.getWinningMoney() * MatchResult.getMatchCount(Rank.FOURCE.getCountOfMatch()));
        reward += (Rank.THIRD.getWinningMoney() * MatchResult.getMatchCount(Rank.THIRD.getCountOfMatch()));
        reward += (Rank.SECOND.getWinningMoney() * MatchResult.getMatchCount(Rank.SECOND.getCountOfMatch()));
        reward += (Rank.FIRST.getWinningMoney() * MatchResult.getMatchCount(Rank.FIRST.getCountOfMatch()));

        double percent = (double) reward / money;
        return String.format("%.2f", percent);
    }
}
