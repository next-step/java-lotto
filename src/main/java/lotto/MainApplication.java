package lotto;

import lotto.model.game.LottoGame;
import lotto.model.winninglotto.WinningLotto;
import lotto.view.input.InputScanner;
import lotto.view.output.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        ResultView.printMyLottos(LottoGame.start(InputScanner.getPurchasePrice()));

        WinningLotto winningLotto
                = WinningLotto.of(InputScanner.getWinningNumbers(), InputScanner.getBonusBall());

        ResultView.printResult(LottoGame.getResult(winningLotto));
    }
}