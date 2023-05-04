package study.lottogame.factory;

import java.util.ArrayList;
import java.util.List;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.Money;

public class LotteriesFactory {

  private LotteriesFactory() {
  }

  public static Lotteries create(Money money) {
    int numberOfLottery = (int) money.getMoneyRate(Lottery.LOTTERY_PRICE);
    return create(numberOfLottery);
  }

  private static Lotteries create(int lotteryCount) {
    List<Lottery> lotteries = new ArrayList<>();
    for (int i = 0; i < lotteryCount; i++) {
      lotteries.add(LotteryFactory.create());
    }
    return new Lotteries(lotteries);
  }
}
