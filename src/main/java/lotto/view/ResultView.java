package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.LotteryStatistic;
import lotto.domain.LotteryTicket;
import lotto.domain.LotteryTickets;
import lotto.domain.WinningLottery;

public class ResultView {

  private static final String BUY_FORMAT = "%d개를 구매했습니다.\n";
  private static final String LOTTERY_FORMAT = "[%s]\n";
  private static final String JOINER = ", ";
  private static final String STATISTICS = "당첨 통계\n---------\n%s\n총 수익률은 %.2f입니다.";
  private static final String MATCHED = "%d개 (%d원)- %d개\n";
  private static final StringBuilder sb = new StringBuilder();
  private static final int STRING_BUILDER_LENGTH = 0;

  public void printLotteryTickets(LotteryTickets lotteryTickets) {
    System.out.printf(BUY_FORMAT, lotteryTickets.size());
    sb.setLength(STRING_BUILDER_LENGTH);

    for (LotteryTicket ticket : lotteryTickets.lotteryTickets()) {
      String joining = ticket.lotteryNumbers().toList().stream()
          .map(Object::toString)
          .collect(Collectors.joining(JOINER));
      sb.append(String.format(LOTTERY_FORMAT, joining));
    }
    System.out.println(sb);
  }

  public void printStatistic(LotteryStatistic statistic) {
    sb.setLength(STRING_BUILDER_LENGTH);

    for (WinningLottery winningLottery : WinningLottery.getValues()) {
      int winningMatchedCount = winningLottery.matchedCount();
      long winningPrice = winningLottery.price();
      long winningCount = statistic.winningCount(winningLottery);

      String formatted = String.format(MATCHED, winningMatchedCount, winningPrice, winningCount);
      sb.append(formatted);
    }
    System.out.printf(STATISTICS, sb, statistic.profit());
  }
}
