package lotto.view;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.view.vo.MatchResult;

import java.util.List;

public class LottoResult {

    public static void printLottos(List<BasicLotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public static void generate(List<BasicLotto> lottos, WinningLotto winningLotto) {
        for (BasicLotto lotto : lottos) {
            int matchCount = winningLotto.checkMatchNumbers(lotto);
            calculateMatchCount(matchCount);
        }

        System.out.println("당첨통계");
        System.out.println("-------");
        System.out.println(Rank.FOURCE.toString() + MatchResult.getMatchCount(Rank.FOURCE.getCountOfMatch()));
        System.out.println(Rank.THIRD.toString() + MatchResult.getMatchCount(Rank.THIRD.getCountOfMatch()));
        System.out.println(Rank.SECOND.toString() + MatchResult.getMatchCount(Rank.SECOND.getCountOfMatch()));
        System.out.println(Rank.FIRST.toString() + MatchResult.getMatchCount(Rank.FIRST.getCountOfMatch()));
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

        System.out.println("총 수익률은 " + String.format("%.2f", percent) + "입니다.");
        System.out.println("수익률이 1이면 본전");

        return String.format("%.2f", percent);
    }
}
