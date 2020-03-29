package lotto;

import lotto.controller.LottoGame;
import lotto.model.Money;
import lotto.view.InputScanner;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Money money = InputScanner.getPurchasePrice();
        int bonusBall = InputScanner.getBonusBall();

        LottoGame lottoGame = new LottoGame(InputView.of(money));
        lottoGame.start();
        ResultView.printMyLottos(lottoGame);

        List<Integer> winningLotto = InputScanner.getWinningLotto();
        ResultView.printResult(lottoGame, winningLotto, bonusBall);
    }
}