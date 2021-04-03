package step3.controller;

import step3.domain.Cash;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.number.LottoNumber;
import step3.domain.number.LottoNumbers;
import step3.domain.result.LottoMatchingResult;
import step3.domain.result.LottoRevenueResult;
import step3.service.Mart;
import step3.strategy.LottoRandomStrategy;
import step3.util.Splitter;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoGame {
  private final Mart mart = new Mart();

  public void start() {
    Cash cash = getCash();
    Lottos boughtLottos = buyLottos(cash);
    cash = cash.notifyBoughtAmount(boughtLottos.quantity());
    ResultView.firstNotice(boughtLottos);

    LottoMatchingResult result = checkLottos(boughtLottos);
    LottoRevenueResult revenueResult = new LottoRevenueResult();
    // TODO 수정
    Cash revenue = revenueResult.calcTotalRevenue(result);
    ResultView.showSpecificResult(result);
    ResultView.showYield(revenue.divide(cash));
  }

  private Cash getCash() {
    int sellerMoney = InputView.starting();
    return new Cash(sellerMoney);
  }

  private Lottos buyLottos(Cash cash) {
    Lottos boughtLottos = mart.buyAllLotto(cash, new LottoRandomStrategy());
    return boughtLottos;
  }

  private LottoMatchingResult checkLottos(Lottos boughtLottos) {
    String expression = InputView.saveLottoNumbers();
    List<LottoNumber> numbers = Splitter.split(expression);
    LottoNumbers lottoNumbers = new LottoNumbers(numbers);
    Lotto matcherLotto = new Lotto(lottoNumbers);

    return boughtLottos.matchLottos(matcherLotto);

  }

}
