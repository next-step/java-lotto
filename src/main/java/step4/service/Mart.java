package step4.service;

import step4.domain.Cash;
import step4.domain.Lotto;
import step4.domain.Lottos;
import step4.domain.number.Count;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;
import step4.exception.InvalidPriceException;
import step4.strategy.LottoStrategy;

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
      throw new InvalidPriceException(ERROR_MESSAGE);
    }
  }

  public Lottos sellAllManualLottos(Cash money, List<String> parameters) {
    Lottos.Builder builder = new Lottos.Builder();
    if (!money.isGreaterEqualProductPrice(Cash.getMultipleLottosPrice(new Count(parameters.size())))) {
      throw new InvalidPriceException(ERROR_MESSAGE);
    }

    parameters.forEach(parameter ->
      builder.add(new Lotto(new LottoNumbers(parameter))));

    return builder.build();
  }

  public Lottos buyAllRandomLottos(Cash money, LottoStrategy lottoStrategy) {

    isBuyablePrice(money);

    return buyLottos(money, lottoStrategy);
  }

  private Lottos buyLottos(Cash sellerMoney, LottoStrategy lottoStrategy) {
    Lottos.Builder lottosBuilder = new Lottos.Builder();
    Cash exchangeMoney = sellerMoney;
    while (exchangeMoney.isAvailableToBuyLotto()) {
      exchangeMoney = exchangeMoney.withdrawal();
      lottosBuilder.add(lottoMaker.makeLotto(lottoStrategy));
    }

    return lottosBuilder.build();
  }

  class LottoMaker {
    private static final int STARTING_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private final List<LottoNumber> lottoNumbers;

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
