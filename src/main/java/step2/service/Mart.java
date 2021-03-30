package step2.service;

import step2.domain.Cash;
import step2.domain.Lottos;
import step2.domain.number.Count;
import step2.strategy.LottoStrategy;

public class Mart {
  private final LottoMaker lottoMaker;

  private static final int LOTTO_PRICE = 1000;
  private static final String ERROR_MESSAGE = "로또를 살 수 없습니다.";

  public Mart(LottoMaker lottoMaker) {
    this.lottoMaker = lottoMaker;
  }

  public Lottos buyAllLotto(Cash money, LottoStrategy lottoStrategy) {
    Cash lottoPrice = new Cash(LOTTO_PRICE);
    isBuyablePrice(money, lottoPrice);

    return buyAllProduct(money, lottoPrice, lottoStrategy);
  }

  private void isBuyablePrice(Cash sellerMoney, Cash productPrice) {
    if (!sellerMoney.isGreaterEqualProductPrice(productPrice)) {
      throw new RuntimeException(ERROR_MESSAGE);
    }
  }

  private Lottos buyAllProduct(Cash sellerMoney, Cash productPrice, LottoStrategy lottoStrategy) {
    Lottos lottos = new Lottos();
    Cash exchangeMoney = sellerMoney;
    while (exchangeMoney.isGreaterEqualProductPrice(productPrice)) {
      exchangeMoney = exchangeMoney.withdrawal(productPrice);
      lottos.addLotto(lottoMaker.makeLotto(lottoStrategy));
    }

    return lottos;
  }

  public Cash notifyBoughtAmount(Count boughts){
    return new Cash(LOTTO_PRICE).multiply(boughts);
  }
}
