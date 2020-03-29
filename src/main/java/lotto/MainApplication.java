package lotto;

import lotto.controller.LottoGame;
import lotto.model.Money;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputScanner;
import lotto.view.InputView;
import lotto.view.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        Money money = InputScanner.getPurchasePrice();

        LottoGame lottoGame = new LottoGame(InputView.of(money));
        lottoGame.start();
        ResultView.printMyLottos(lottoGame);

        WinningLottoNumbers winningLotto = InputScanner.getWinningLotto();
        int bonusBall = InputScanner.getBonusBall();

        ResultView.printResult(lottoGame, winningLotto, bonusBall);
    }
}