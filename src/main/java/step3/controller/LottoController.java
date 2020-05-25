package step3.controller;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
  private final static InputView inputView = InputView.getInstance();
  private final static ResultView resultView = ResultView.getInstance();

  public static void main(String[] args) {

    long price = inputView.inputPrice();
    Lottos lottos = LottoShop.buyLotto(price);
    resultView.printLottoList(lottos);

    Lotto winning = LottoGenerator.generateLotto(inputView.inputWinning());
    int bonusNumber = inputView.inputBonus();
    LottoGame lottoGame = LottoGame.of(lottos, winning, bonusNumber);

    resultView.printStat(lottoGame);
    resultView.printPayoffRatio(lottoGame.getPayoffRatio());

  }

}
