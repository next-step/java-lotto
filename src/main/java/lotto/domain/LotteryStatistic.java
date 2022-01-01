package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LotteryStatistic {

  private static final int FIRST_REVENUE = 0;
  private static final int FIRST_PROFIT = 0;
  private static final int NONE_COUNT = 0;
  private static final int ADD_COUNT = 1;
  private static final int TO_INT = 100;
  private static final double TO_DOUBLE = 100.0;
  private final Map<WinningLottery, Integer> totalLotteries;
  private double profit;

  public LotteryStatistic() {
    this.totalLotteries = new EnumMap<>(WinningLottery.class);
    this.profit = FIRST_PROFIT;
  }

  public void produceTickets(LotteryTickets tickets, LotteryNumbers winningNumbers) {
    long revenue = FIRST_REVENUE;

    for (int i = 0; i < tickets.size(); i++) {
      WinningLottery winningLottery = tickets.lotteryTicket(i)
          .lotteryNumbers()
          .rank(winningNumbers);

      putMap(winningLottery);
      revenue += winningLottery.price();
    }

    profit = (double) revenue / (double) tickets.cost();
  }

  public double profit() {
    return Math.floor(profit * TO_INT) / TO_DOUBLE;
  }

  public int winningCount(WinningLottery winningLottery) {
    if (!totalLotteries.containsKey(winningLottery)) {
      return NONE_COUNT;
    }
    return totalLotteries.get(winningLottery);
  }

  private void putMap(WinningLottery winningLottery) {
    totalLotteries.merge(winningLottery, ADD_COUNT, Integer::sum);
  }
}
