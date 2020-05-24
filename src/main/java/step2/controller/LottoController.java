package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.domain.LottoShop;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
  private final static InputView inputView = InputView.getInstance();
  private final static ResultView resultView = ResultView.getInstance();

  public static void main(String[] args) {

    long price = inputView.inputPrice();
    LottoShop lottoShop = LottoShop.of(price);
    resultView.printLottoList(lottoShop);

    Lotto winning = Lotto.of(inputView.inputWinning());
    LottoGame lottoGame = LottoGame.of(lottoShop, winning);

    resultView.printStat(lottoGame);
    resultView.printPayoffRatio(lottoGame.getPayoffRatio());

  }

}
