package lotto.step3.controller;

import lotto.step3.domain.*;
import lotto.step3.view.InputView;
import lotto.step3.view.ResultView;

public class LottoController {
  private final static InputView inputView = InputView.getInstance();
  private final static ResultView resultView = ResultView.getInstance();

  public static void main(String[] args) {

    long price = inputView.inputPrice();
    Lottos lottos = LottoShop.buyLotto(price);
    resultView.printLottoList(lottos);

    LottoResult lottoResult = LottoResult.of(lottos, WinningLotto.of(
      LottoGenerator.generateLotto(inputView.inputWinning()),
      inputView.inputBonus()
    ));
    resultView.printStat(lottoResult);
    resultView.printPayoffRatio(lottoResult.resultLottoGamePayOffRatio());

  }

}
