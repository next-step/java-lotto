package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.HitNumbers;
import lotto.domain.LotteryMachine;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

  public void run() {
    Amount amount = new Amount(InputView.inputPriceOfBuy(),InputView.inputManualBuy());
    Lottos lottos = new Lottos(amount);

    ResultView.showAmountOfLotto(amount);
    ResultView.showLottoNumbers(lottos);

    HitNumbers hitNumbers = new HitNumbers(InputView.inputPrizeNumber(),
        InputView.inputBonusNumber());
    LotteryMachine lottery = new LotteryMachine(hitNumbers);
    lottery.draw(lottos);

    ResultView.showLotteryResult(lottery, amount);
  }
}
