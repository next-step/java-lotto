package lotto.service;

import lotto.domain.Lotteries;
import lotto.domain.LottoMoney;

public class LottoGameApplication {

  private static final int EACH_LOTTO_COST = 1000;

  public LottoMoney lottoMoney;

  private Lotteries lotteries;

  public LottoGameApplication(int money) {
    this.lottoMoney = new LottoMoney(money);
  }

  public int getNumberOfLotto() {
    return lottoMoney.countLottoToMoney(Operation.DIVISION_SHARE, EACH_LOTTO_COST);
  }

  public void buyLotteries() {
    lotteries = new Lotteries(getNumberOfLotto());
  }

  public Lotteries getLotteriesInfo() {
    return lotteries;
  }

}
