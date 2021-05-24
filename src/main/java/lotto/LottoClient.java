package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoSeller;
import lotto.domain.RandomNumberGenerator;
import lotto.input.InputView;
import lotto.output.ResultView;

import java.util.Random;
import java.util.Scanner;

public final class LottoClient {

  public static void main(String[] args) {

    LottoGame lottoGame = new LottoGame(
        new InputView(new Scanner(System.in)),
        new LottoSeller(new RandomNumberGenerator(new Random())),
        new ResultView()
    );

    lottoGame.start();
  }
}
