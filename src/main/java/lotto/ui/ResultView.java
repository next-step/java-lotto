package lotto.ui;

import static java.lang.String.format;

import java.io.PrintStream;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Statistic;
import lotto.domain.StatisticInfo;

public class ResultView {

  private static final double MINIMUM_PROFIT_RATE = 1.0;
  private static final String PURCHASED_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
  private static final String STATISTICS_HEAD = "당첨 통계";
  private static final String HEAD_BODY_SPLIT_LINE = "---------";
  private static final String STATISTIC_DETAIL_FORMAT = "%d개 일치 (%s)- %d개";
  private static final String STATISTIC_DETAIL_MATCH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%s)- %d개";
  private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
  private static final String GAIN = "이득";
  private static final String LOSS = "손해";
  private static final PrintStream printStream = System.out;

  public static void printLottoCount(int manual, int random) {
    printStream.printf(PURCHASED_LOTTO_COUNT, manual, random);
  }

  public static void printLottoTickets(LottoTickets lottoTickets) {
    lottoTickets.tickets()
        .stream()
        .map(ResultView::formattingLottoNumbers)
        .forEach(printStream::println);
  }

  private static String formattingLottoNumbers(LottoTicket lottoTicket) {
    return lottoTicket.getLottoNumbers()
        .stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  public static void printStatistics(StatisticInfo statisticInfo) {
    printStream.println(STATISTICS_HEAD);
    printStream.println(HEAD_BODY_SPLIT_LINE);
    statisticInfo.getStatistics().forEach(ResultView::printStatistic);
    printRateOfReturn(statisticInfo);
  }

  private static void printStatistic(Statistic statistic) {
    if (statistic.isMatchBonus()) {
      printStream.println(
          format(STATISTIC_DETAIL_MATCH_BONUS_FORMAT, statistic.getMatchCount(),
              statistic.getPrizeMoney().won(),
              statistic.getMatchedPrizeCount()));
      return;
    }

    printStream.println(
        format(STATISTIC_DETAIL_FORMAT, statistic.getMatchCount(), statistic.getPrizeMoney().won(),
            statistic.getMatchedPrizeCount()));
  }

  private static void printRateOfReturn(StatisticInfo statistic) {
    printStream.println(format(RATE_OF_RETURN_FORMAT, statistic.rateOfReturn(),
        getProfitOrLoss(statistic)));
  }

  private static String getProfitOrLoss(StatisticInfo statistic) {
    return statistic.rateOfReturn() >= MINIMUM_PROFIT_RATE ? GAIN : LOSS;
  }
}
