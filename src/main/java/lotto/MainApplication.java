package lotto;

import lotto.controller.LottoGame;
import lotto.view.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        ResultView.printMyLottos(LottoGame.ready());
        ResultView.printGameResult(LottoGame.start());
    }
}