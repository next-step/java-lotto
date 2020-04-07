package lotto.view;

import static lotto.domain.LottoGames.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.LottoGame;
import lotto.domain.WinningResult;
import lotto.domain.model.LottoBall;
import lotto.domain.model.Rank;
import lotto.domain.model.Trilean;

public class ResultView {
  private static final String RESULT_FORMAT = "%s개 일치%s(%s원) - %s개\n";
  private static final String MATCH_BONUS_BALL = ", 보너스 볼 일치";
  private static final String SPACE = " ";
  private static final String RATE_OF_RETURN = "총 수익률은 %.2f입니다.";
  private static final String WINNING_STATISTICS = "당첨 통계\n---------";

  public static void printBuying(List<LottoGame> lottoGames) {
    lottoGames.stream()
        .map(LottoGame::getLottoBalls)
        .forEach(lottoNos -> System.out.println(
            lottoNos.stream()
                .map(LottoBall::toString)
                .collect(Collectors.joining(", ", "[", "]"))
        ));
  }

  public static void printResult(WinningResult winningResult) {
    Map<Rank, Long> rankStatistic = winningResult.getRanks().stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    printRankStatistic(rankStatistic);
    printRateOfReturn(rankStatistic);
  }

  private static void printRankStatistic(Map<Rank, Long> rankStatistic) {
    System.out.println(WINNING_STATISTICS);
    Arrays.stream(Rank.values())
        .filter(rank -> rank.getMatchCount() > 0)
        .forEach(rank -> System.out.printf(
            RESULT_FORMAT,
            rank.getMatchCount(),
            rank.getShouldMatchBonus() == Trilean.TRUE ? MATCH_BONUS_BALL : SPACE,
            rank.getWinningMoney(),
            Optional.ofNullable(rankStatistic.get(rank)).orElse(0L)
        ));
  }

  private static void printRateOfReturn(Map<Rank, Long> rankStatistic) {
    long prizeMoney = rankStatistic.entrySet().stream()
        .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
        .sum();
    double purchaseAmount = rankStatistic.values().stream()
        .mapToDouble(v -> v).sum() * LOTTO_PRICE;
    double rateOfReturn = prizeMoney / purchaseAmount;

    System.out.printf(RATE_OF_RETURN, rateOfReturn);
  }
}
