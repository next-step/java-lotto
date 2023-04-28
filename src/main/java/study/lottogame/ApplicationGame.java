package study.lottogame;

import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.Money;
import study.lottogame.factory.LotteriesFactory;
import study.lottogame.ui.InputView;

public class ApplicationGame {

  public static void main(String[] args) {
    Money money = InputView.inputPurchaseMoney();
    int lotteryCount = money.divideMoney(Lottery.LotteryPrice);
    Lotteries lotteries = LotteriesFactory.createLotteries(lotteryCount);
  }
}
