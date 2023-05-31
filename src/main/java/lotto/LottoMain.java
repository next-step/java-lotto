package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(new Scanner(System.in)),
                new ResultView(),
                new LottoGame(new Lottos()),
                new LottoGenerator());

        lottoController.buy();
        lottoController.result();
    }
}
