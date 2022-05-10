package lotto.ui;

import static java.lang.String.format;

import java.io.PrintStream;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Statistic;
import lotto.domain.Statistics;

public class ResultView {

  private static final String PURCHASED_LOTTO_COUNT = "개를 구매했습니다.";
  private static final String STATISTICS_HEAD = "당첨 통계";
  private static final String HEAD_BODY_SPLIT_LINE = "---------";
  private static final String STATISTIC_DETAIL_FORMAT = "%d개 일치 (%s)- %d개";
  private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
  private static final String GAIN = "이득";
  private static final String LOSS = "손해";
  private static final PrintStream printStream = System.out;

  public static void printLottoCount(int lottoCount) {
    printStream.println(lottoCount + PURCHASED_LOTTO_COUNT);
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

  public static void printStatistics(Statistics statistics) {
    printStream.println(STATISTICS_HEAD);
    printStream.println(HEAD_BODY_SPLIT_LINE);
    statistics.getStatistics().forEach(ResultView::printStatistic);
    printRateOfReturn(statistics);
  }

  private static void printStatistic(Statistic statistic) {
    printStream.println(
        format(STATISTIC_DETAIL_FORMAT, statistic.getMatchCount(), statistic.getPrizeMoney().won(),
            statistic.getMatchedPrizeCount()));
  }

  private static void printRateOfReturn(Statistics statistic) {
    printStream.println(format(RATE_OF_RETURN_FORMAT, statistic.rateOfReturn(),
        getProfitOrLoss(statistic)));
  }

  private static String getProfitOrLoss(Statistics statistic) {
    return statistic.rateOfReturn() >= 1.0 ? GAIN : LOSS;
  }
}
