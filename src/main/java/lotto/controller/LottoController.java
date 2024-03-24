package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void buyLotto() {
        Fee fee = InputView.payForGames();
        Lottos lottos = lottoGenerator.generateLottos(fee);
        ResultView.showLottos(lottos);
        Lotto winningNumber = Lotto.from(InputView.inputWinningNumber());
        LottoMatchLogic lottoMatchLogic = new LottoMatchLogic(lottos);
        ResultView.showRanks(lottoMatchLogic.checkRank(winningNumber, fee));
    }
}
