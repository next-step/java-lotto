package step4.controller;

import step4.domain.Cash;
import step4.domain.Lotto;
import step4.domain.Lottos;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;
import step4.domain.result.LottoMatchingResult;
import step4.service.Mart;
import step4.strategy.LottoRandomStrategy;
import step4.util.Splitter;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoGame {
  private final Mart mart = new Mart();

  public void start() {
    Cash cash = getCash();
    Lottos boughtLottos = buyLottos(cash);
    cash = cash.notifyBoughtAmount(boughtLottos.quantity());
    ResultView.firstNotice(boughtLottos);

    LottoMatchingResult result = checkLottos(boughtLottos);
    Cash revenue = result.calcTotalRevenue();
    ResultView.showSpecificResult(result);
    ResultView.showYield(revenue.divideReturningString(cash));
  }

  private Cash getCash() {
    Long sellerMoney = InputView.starting();
    return new Cash(sellerMoney);
  }

  private Lottos buyLottos(Cash cash) {
    Lottos boughtLottos = mart.buyAllLotto(cash, new LottoRandomStrategy());
    return boughtLottos;
  }

  private LottoMatchingResult checkLottos(Lottos boughtLottos) {
    String expression = InputView.saveLottoNumbers();
    List<LottoNumber> numbers = Splitter.split(expression);
    LottoNumber bonusBall = new LottoNumber(InputView.saveBonusBall());

    LottoNumbers lottoNumbers = new LottoNumbers(numbers);
    Lotto matcherLotto = new Lotto(lottoNumbers);

    return boughtLottos.matchLottosWithBonusBall(matcherLotto, bonusBall);

  }

}
