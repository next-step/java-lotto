package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoSeller;
import lotto.domain.RandomNumberGenerator;
import lotto.input.InputView;
import lotto.output.ResultView;

import java.util.Random;

public final class LottoClient {

  public static void main(String[] args) {

    LottoGame lottoGame = new LottoGame(
        new InputView(),
        new LottoSeller(new RandomNumberGenerator(new Random())),
        new ResultView()
    );

    lottoGame.start();
  }
}
