package step2.service;

import step2.domain.Cash;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;
import step2.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mart {
  private static final String ERROR_MESSAGE = "로또를 살 수 없습니다.";
  private final LottoMaker lottoMaker;

  public Mart() {
    this.lottoMaker = new LottoMaker();
  }

  private void isBuyablePrice(Cash sellerMoney) {
    if (!sellerMoney.isAvailableToBuyLotto()) {
      throw new RuntimeException(ERROR_MESSAGE);
    }
  }

  public Lottos buyAllLotto(Cash money, LottoStrategy lottoStrategy) {
    isBuyablePrice(money);

    return buyLottos(money, lottoStrategy);
  }

  private Lottos buyLottos(Cash sellerMoney, LottoStrategy lottoStrategy) {
    Lottos lottos = new Lottos();
    Cash exchangeMoney = sellerMoney;
    while (exchangeMoney.isAvailableToBuyLotto()) {
      exchangeMoney = exchangeMoney.withdrawal();
      lottos.addLotto(lottoMaker.makeLotto(lottoStrategy));
    }

    return lottos;
  }

  class LottoMaker {
    private final List<LottoNumber> lottoNumbers;

    private static final int STARTING_NUMBER = 1;
    private static final int LAST_NUMBER = 45;

    protected LottoMaker() {
      List<LottoNumber> lottoNumbers = new ArrayList<>();
      for (int i = STARTING_NUMBER; i <= LAST_NUMBER; i++) {
        lottoNumbers.add(new LottoNumber(i));
      }
      this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    protected Lotto makeLotto(LottoStrategy lottoStrategy) {
      LottoNumbers lottoNumbers = lottoStrategy.markingNumbers(this.lottoNumbers);
      return new Lotto(lottoNumbers);
    }
  }
}
