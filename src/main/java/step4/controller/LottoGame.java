package step4.controller;

import step4.domain.Cash;
import step4.domain.Lotto;
import step4.domain.Lottos;
import step4.domain.ManualLottoParameter;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;
import step4.domain.result.LottoMatchingResult;
import step4.service.Mart;
import step4.strategy.LottoRandomStrategy;
import step4.util.Splitter;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
  private static final int ZERO = 0;

  private final Mart mart = new Mart();

  public void start() {
    Cash cash = getCash();
    Lottos boughtLottos = setupAllLottos(cash);
    cash = cash.notifyBoughtAmount(boughtLottos.quantity());

    LottoMatchingResult result = checkLottos(boughtLottos);
    Cash revenue = result.calcTotalRevenue();
    ResultView.showSpecificResult(result);
    ResultView.showYield(revenue.divideReturningString(cash));
  }

  private Lottos setupAllLottos(Cash cash) {
    Lottos boughtManualLottos = setupBoughtManualLottos(cash);
    Cash remainingCash = cash.withdrawal(cash.notifyBoughtAmount(boughtManualLottos.quantity()));
    Lottos boughtLottos = buyLottos(remainingCash);
    Lottos allLottos = boughtManualLottos.mergeLottos(boughtLottos);
    ResultView.firstNotice(boughtManualLottos, boughtLottos);
    return allLottos;
  }

  private Lottos setupBoughtManualLottos(Cash cash) {
    int boughtCounts = InputView.saveManualProducts();
    List<String> typedLottoParameters = new ArrayList<>();
    List<ManualLottoParameter> lottoParameters = new ArrayList<>();

    if (boughtCounts > ZERO) {
      typedLottoParameters = InputView.saveManualLottoNumbers(boughtCounts);
    }

    for (String typedLottoParameter : typedLottoParameters) {
      lottoParameters.add(new ManualLottoParameter(typedLottoParameter));
    }

    return mart.sellAllManualLottos(cash, lottoParameters);
  }

  private Cash getCash() {
    Long sellerMoney = InputView.starting();
    return new Cash(sellerMoney);
  }

  private Lottos buyLottos(Cash cash) {
    return mart.buyAllRandomLottos(cash, new LottoRandomStrategy());
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
