package lotto.domain.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.LottoGame;
import lotto.domain.LottoNo;
import lotto.domain.Rank;

public class ResultView {
  private static final String RESULT_FORMAT = "%s개 일치%s(%s원) - %s개\n";
  private static final String MATCH_BONUS_BALL = ", 보너스 볼 일치";
  private static final String SPACE = " ";
  private static final String RATE_OF_RETURN = "총 수익률은 %.2f입니다.";
  private static final String WINNING_STATISTICS = "당첨 통계\n---------";

  public static void printBuying(List<LottoGame> lottoGames) {
    lottoGames.stream()
        .map(LottoGame::getLottoNos)
        .forEach(lottoNos -> System.out.println(lottoNos.stream().map(LottoNo::toString).collect(Collectors.joining(", ", "[", "]"))));
  }

  public static void printResult(List<Rank> ranks) {
    Map<Rank, Long> rankStatistic = ranks.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(WINNING_STATISTICS);
    Arrays.stream(Rank.values())
        .filter(rank -> rank.getMatchCount() > 0)
        .forEach(rank -> System.out.printf(
            RESULT_FORMAT,
            rank.getMatchCount(),
            rank.getShouldMatchBonus() ? MATCH_BONUS_BALL : SPACE,
            rank.getWinningMoney(),
            Optional.ofNullable(rankStatistic.get(rank)).orElse(0L)
        ));

    double rateOfReturn = rankStatistic.entrySet()
        .stream()
        .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
        .sum() / (double) (ranks.size() * 1000);

    System.out.printf(RATE_OF_RETURN, rateOfReturn);
  }
}
