package step2;

import step2.view.InputView;
import step2.view.OutputView;

public class LottoMain {

  public static void main(String[] args) {
    int lottoPrice = InputView.getLottoPrice();
    LottoGame game = new LottoGame(lottoPrice);
    OutputView.printLottoCount(game.getCount());
  }

}
