package lotto;

import lotto.model.game.LottoGame;
import lotto.model.winninglotto.WinningLotto;
import lotto.view.input.InputScanner;
import lotto.view.output.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputScanner.getPurchasePrice());
        ResultView.printMyLottos(lottoGame.start());

        WinningLotto winningLotto
                = WinningLotto.of(InputScanner.getWinningNumbers(), InputScanner.getBonusBall());
        ResultView.printResult(lottoGame.getResult(winningLotto));
    }
}