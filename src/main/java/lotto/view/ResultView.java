package lotto.view;

import lotto.model.gameresult.GameResult;
import lotto.model.lottos.Lottos;
import lotto.model.Rank;
import lotto.model.gameresult.MatchResults;

import static lotto.model.Rank.SECOND;

public class ResultView {
    public static void printMyLottos(Lottos lottos) {
        lottos.createAllLottos().stream()
                .forEach(it -> System.out.println(it.toString()));
    }

    public static void printGameResult(GameResult gameResult) {
        printResults(gameResult);
        printEarningRate(gameResult);
    }

    private static void printResults(GameResult gameResult) {
        MatchResults matchResults = gameResult.getMatchResults();
        for (Rank rank : Rank.values()) {
            printRankResult(rank);
            System.out.println(matchResults.getCount(rank) + "개");
        }
    }

    private static void printRankResult(Rank rank) {
        System.out.print(rank.getMatchCount() + "개 일치");
        if (SECOND.equals(rank)) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.print(" (" + rank.getWinningMoney() + ") -> ");
    }

    private static void printEarningRate(GameResult gameResult) {
        System.out.println("총 수익률은 " + gameResult.getEarningRate() + "% 입니다.");
    }
}