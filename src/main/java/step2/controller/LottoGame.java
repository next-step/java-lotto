package step2.controller;

import step2.domain.*;
import step2.domain.number.Count;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;
import step2.service.LottoMaker;
import step2.service.Mart;
import step2.strategy.LottoRandomStrategy;
import step2.util.Splitter;
import step2.view.CommonView;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGame {
  private final Mart mart = new Mart(new LottoMaker());

  public void start() {
    Cash cash = getCash();
    Lottos boughtLottos = buyLottos(cash);
    cash = mart.notifyBoughtAmount(new Count(boughtLottos.quantity()));
    ResultView.firstNotice(boughtLottos);

    LottoResult result = checkLottos(boughtLottos);
    result.calcYield(cash);
    ResultView.showSpecificResult(result);
  }

  private Cash getCash(){
    int sellerMoney = InputView.starting();
    return new Cash(sellerMoney);
  }

  private Lottos buyLottos(Cash cash){
    Lottos boughtLottos = mart.buyAllLotto(cash, new LottoRandomStrategy());
    return boughtLottos;
  }

  private LottoResult checkLottos(Lottos boughtLottos){
    String expression = InputView.saveLottoNumbers();
    List<LottoNumber> numbers = Splitter.split(expression);
    LottoNumbers lottoNumbers = new LottoNumbers(numbers);
    Lotto matcherLotto =new Lotto(lottoNumbers);

    return  boughtLottos.matchLottos(matcherLotto);

  }

}
