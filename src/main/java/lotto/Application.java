package lotto;

import lotto.controller.LottoController;
import lotto.strategy.RandomNumberGenerateStrategy;

public class Application {

  public static void main(String[] args) {
    LottoController lottoController = new LottoController();
    lottoController.lottoDraw(new RandomNumberGenerateStrategy());
  }
}
