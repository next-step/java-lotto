package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.LottoGame;
import lotto.domain.RankStatistic;
import lotto.domain.WinningResult;
import lotto.domain.model.LottoBall;
import lotto.domain.model.Rank;
import lotto.domain.model.Trilean;

public class ResultView {
  private static final String RESULT_FORMAT = "%s개 일치%s(%s원) - %s개\n";
  private static final String PURCHASE_HISTORY_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
  private static final String MATCH_BONUS_BALL = ", 보너스 볼 일치";
  private static final String SPACE = " ";
  private static final String RATE_OF_RETURN = "총 수익률은 %.2f입니다.";
  private static final String WINNING_STATISTICS = "당첨 통계\n---------";

  public static void printBuying(List<LottoGame> lottoGames, List<LottoGame> manualGames) {
    int manualCount = manualGames.size();
    int autoCount = lottoGames.size() - manualCount;
    System.out.println();
    System.out.printf(PURCHASE_HISTORY_FORMAT, manualCount, autoCount);
    printGames(lottoGames);
  }

  private static void printGames(List<LottoGame> lottoGames) {
    lottoGames.stream()
        .map(LottoGame::getLottoBalls)
        .map(ResultView::formatLottoBalls)
        .forEach(System.out::println);
  }

  private static String formatLottoBalls(Set<LottoBall> lottoBalls) {
    return lottoBalls.stream()
        .map(LottoBall::toString)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  //-----------------------------------------------------------------------

  public static void printWinningResult(WinningResult winningResult) {
    RankStatistic rankStatistic = winningResult.deriveStatistics();

    printRankStatistic(rankStatistic);
    printRateOfReturn(rankStatistic);
  }

  private static void printRankStatistic(RankStatistic rankStatistic) {
    System.out.println(WINNING_STATISTICS);
    Arrays.stream(Rank.values())
        .filter(rank -> rank.getMatchCount() > 0)
        .forEach(rank -> printRankResult(rank, rankStatistic.countWinsOf(rank)));
  }

  private static void printRankResult(Rank rank, long count) {
    System.out.printf(
        RESULT_FORMAT,
        rank.getMatchCount(),
        rank.getShouldMatchBonus() == Trilean.TRUE ? MATCH_BONUS_BALL : SPACE,
        rank.getWinningMoney(),
        count
    );
  }

  private static void printRateOfReturn(RankStatistic rankStatistic) {
    double rateOfReturn = rankStatistic.calculateYield();

    System.out.printf(RATE_OF_RETURN, rateOfReturn);
  }
}
