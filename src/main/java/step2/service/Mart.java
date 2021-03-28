package step2.service;

import step2.domain.Cash;
import step2.domain.Lotto;
import step2.domain.Lottos;

public class Mart {
  private static final int LOTTO_PRICE = 1000;
  private static final String ERROR_MESSAGE = "로또를 살 수 없습니다.";

  private Mart() {

  }

  public static Lottos buyAllLotto(Cash money) {
    Cash lottoPrice = new Cash(LOTTO_PRICE);
    isBuyablePrice(money, lottoPrice);

    return buyAllProduct(money, lottoPrice);
  }

  private static void isBuyablePrice(Cash sellerMoney, Cash productPrice){
    if (!sellerMoney.isGreaterEqualProductPrice(productPrice)) {
      throw new RuntimeException(ERROR_MESSAGE);
    }
  }

  private static Lottos buyAllProduct(Cash sellerMoney, Cash productPrice){
    Lottos lottos = new Lottos();
    Cash exchangeMoney = sellerMoney;
    while (exchangeMoney.isGreaterEqualProductPrice(productPrice)) {
      exchangeMoney = exchangeMoney.withdrawal(productPrice);
      lottos.addLotto(new Lotto());
    }

    return lottos;
  }
}
