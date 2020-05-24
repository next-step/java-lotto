package step3.controller;

import step3.domain.Lotto;
import step3.domain.LottoGame;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
  private final LottoGame lottoGame;
  private final InputView inputView = InputView.getInstance();
  private final ResultView resultView = ResultView.getInstance();

  private LottoController (LottoGame lottoGame) {
    this.lottoGame = lottoGame;
  }

  public static LottoController of () {
    return new LottoController(LottoGame.of(InputView.getInstance().inputPrice()));
  }

  private LottoController viewLottoGame () {
    resultView.printLottoGame(lottoGame);
    return this;
  }

  public LottoController viewPayoff () {
    resultView.printPayoffRatio(lottoGame.getPayoffRatio());
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

  public LottoController inputBonusNumber () {
    return this.inputBonusNumber(inputView.inputBonus());
  }

  public LottoController inputBonusNumber (int bonusNumber) {
    lottoGame.setBonusNumber(bonusNumber);
    return this;
  }

  public LottoController viewStat () {
    resultView.printStat(lottoGame);
    return this;
  }

  public static void main(String[] args) {
    LottoController.of()
                   .viewLottoGame()
                   .inputWinning()
                   .inputBonusNumber()
                   .viewStat()
                   .viewPayoff();
  }

}
