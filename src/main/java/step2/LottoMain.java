package step2;

import step2.domain.WinningLotto;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoMain {

  public static void main(String[] args) {
    String lottoPrice = InputView.getLottoPrice();
    LottoGame game = new LottoGame(Integer.parseInt(lottoPrice));
    OutputView.printLottoCount(game.getCount());
    System.out.println();

    String winning = InputView.getWinningNumbers();
    WinningLotto winningLotto = new WinningLotto(winning);
    System.out.println("winning");
  }

}
