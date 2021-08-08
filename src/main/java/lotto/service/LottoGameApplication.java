package lotto.service;

import lotto.domain.Lotteries;
import lotto.domain.LottoMoney;

public class LottoGameApplication {

  private static final int EACH_LOTTO_COST = 1000;

  private final LottoMoney lottoMoney;

  public LottoGameApplication(LottoMoney money) {
    this.lottoMoney = money;
  }

  public int getNumberOfLotto() {
    return lottoMoney.countLottoToMoney(Operation.DIVISION_SHARE, EACH_LOTTO_COST);
  }

  public Lotteries createLotteries() {
    return new Lotteries(getNumberOfLotto());
  }

}