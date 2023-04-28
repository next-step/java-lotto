package study.lottogame.factory;

import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteriesFactory {

  private LotteriesFactory() {
  }

  public static Lotteries createLotteries(int lotteryCount) {
    List<Lottery> lotteries = new ArrayList<>();
    for (int i = 0; i < lotteryCount; i++) {
      lotteries.add(LotteryFactory.create());
    }
    return new Lotteries(lotteries);
  }
}
