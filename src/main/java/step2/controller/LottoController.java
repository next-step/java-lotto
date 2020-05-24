package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
  private final LottoGame lottoGame;
  private final static InputView inputView = InputView.getInstance();
  private final static ResultView resultView = ResultView.getInstance();

  private LottoController (LottoGame lottoGame) {
    this.lottoGame = lottoGame;
  }

  private LottoController viewLottoGame () {
    resultView.printLottoGame(lottoGame);
    return this;
  }

  public LottoController inputWinning (Lotto winning) {
    lottoGame.setWinningNumber(winning);
    return this;
  }

  public LottoController inputWinning () {
    Lotto winning = Lotto.of(inputView.inputWinning());
    return this.inputWinning(winning);
  }

  public LottoController viewStat () {
    resultView.printStat(lottoGame);
    return this;
  }

  public void viewPayoff () {
    resultView.printPayoffRatio(lottoGame.getPayoff());
  }

  public static LottoController of (LottoGame lottoGame) {
    return new LottoController(lottoGame);
  }

  public static LottoController of () {
    long price = inputView.inputPrice();
    return of(LottoGame.of(price));
  }

  public static void main(String[] args) {
    LottoController.of()
                   .viewLottoGame()
                   .inputWinning()
                   .viewStat()
                   .viewPayoff();
  }

}
