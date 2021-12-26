package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LotteryStatistic {

  private final Map<WinningLottery, Integer> totalLotteries;
  private double profit;

  public LotteryStatistic() {
    this.totalLotteries = new EnumMap<>(WinningLottery.class);
    this.profit = 0;
  }

  public void produceTickets(LotteryTickets tickets, LotteryNumbers winningNumbers) {
    long revenue = 0;

    for (int i = 0; i < tickets.size(); i++) {
      WinningLottery winningLottery = tickets.getLotteryTicket(i)
          .getLotteryNumbers()
          .rank(winningNumbers);

      putMap(winningLottery);
      revenue += winningLottery.getPrice();
    }

    profit = (double) revenue / (double) tickets.cost();
  }

  public double getProfit() {
    return Math.floor(profit * 100) / 100.0;
  }

  public int winCount(WinningLottery winningLottery) {
    if (!totalLotteries.containsKey(winningLottery)) {
      return 0;
    }
    return totalLotteries.get(winningLottery);
  }

  private void putMap(WinningLottery winningLottery) {
    totalLotteries.putIfAbsent(winningLottery, totalLotteries.getOrDefault(winningLottery, 0) + 1);
  }
}
