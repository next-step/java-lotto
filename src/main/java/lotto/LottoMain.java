package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(new Scanner(System.in)),
                new ResultView(),
                new LottoGame(
                        new Lottos(
                                new ArrayList<>(),
                                new LottoNumberGenerator())
                )
        );

        lottoController.buy();
        lottoController.result();
    }
}
