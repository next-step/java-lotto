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

    Prizes prizes = Prizes.of(lottos, WinningLotto.of(
      LottoGenerator.generateLotto(inputView.inputWinning()),
      inputView.inputBonus()
    ));
    resultView.printStat(prizes);

    LottoGame lottoGame = LottoGame.of(lottos, prizes);
    resultView.printPayoffRatio(lottoGame.getPayoffRatio());

  }

}
