package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.HitNumber;
import lotto.domain.Lottery;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

  public void run() {
    Amount amount = new Amount(InputView.inputPriceOfBuy());
    List<LottoNumbers> lottos = LottoStore.generateLottos(amount.getAmount());

    ResultView.showAmountOfLotto(amount.getAmount());
    ResultView.showLottoNumbers(lottos);

    HitNumber hitNumber = new HitNumber(InputView.inputPrizeNumber());
    Lottery lottery = new Lottery(hitNumber);
    lottery.draw(lottos);
  }
}
