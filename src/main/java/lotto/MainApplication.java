package lotto;

import lotto.controller.LottoGame;
import lotto.model.lottos.Lottos;
import lotto.view.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        Lottos lottos = LottoGame.ready();

        ResultView.printMyLottos(lottos);
        ResultView.printGameResult(LottoGame.start(lottos));
    }
}