package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoController {
  private final static InputView inputView = InputView.getInstance();
  private final static ResultView resultView = ResultView.getInstance();

  public static void main(String[] args) {

    long price = inputView.inputPrice();
    Lottos lottos = LottoShop.buyLotto(price);
    resultView.printLottoList(lottos);

    Lotto winning = LottoGenerator.generateLotto(inputView.inputWinning());
    LottoGame lottoGame = LottoGame.of(lottos, winning);

    resultView.printStat(lottoGame);
    resultView.printPayoffRatio(lottoGame.getPayoffRatio());

  }

}
