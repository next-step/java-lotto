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
  private static final String MATCHED_COUNT = "%d개 일치";
  private static final String MATCHED_BONUS = ", 보너스 볼 일치";
  private static final String WINNING_PRICE = "(%d원)";
  private static final String WINNING_COUNT = "%d개";
  private static final String EMPTY_STRING = " ";
  private static final String EMPTY_LINE = "\n";
  private static final StringBuilder sb = new StringBuilder();
  private static final int STRING_BUILDER_LENGTH = 0;

  public void printLotteryTickets(LotteryTickets lotteryTickets) {
    System.out.printf(BUY_FORMAT, lotteryTickets.size());
    sb.setLength(STRING_BUILDER_LENGTH);

    for (LotteryTicket ticket : lotteryTickets.getValues()) {
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
      int winningMatchedCount = winningLottery.getMatchedCount();
      long winningPrice = winningLottery.getPrice();
      long winningCount = statistic.winningCount(winningLottery);

      sb.append(String.format(MATCHED_COUNT, winningMatchedCount));
      sb.append(bonusString(winningLottery));
      sb.append(String.format(WINNING_PRICE, winningPrice));
      sb.append(String.format(WINNING_COUNT, winningCount));
      sb.append(EMPTY_LINE);
    }
    System.out.printf(STATISTICS, sb, statistic.profit());
  }

  private String bonusString(WinningLottery winningLottery) {
    if (WinningLottery.matchedBonus(winningLottery)) {
      return MATCHED_BONUS;
    }
    return EMPTY_STRING;
  }
}
