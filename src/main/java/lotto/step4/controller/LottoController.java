package lotto.step4.controller;

import lotto.step4.domain.*;
import lotto.step4.view.InputView;
import lotto.step4.view.ResultView;

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
