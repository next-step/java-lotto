package lotto;

import lotto.controller.LottoGame;
import lotto.view.InputScanner;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        String inputPrice = InputScanner.getPurchasePrice();

        LottoGame lottoGame = new LottoGame(InputView.of(inputPrice));
        lottoGame.start();
        ResultView.printMyLottos(lottoGame);

        List<Integer> winningLotto = InputScanner.getWinningLotto();
        ResultView.printResult(lottoGame, winningLotto);
    }
}