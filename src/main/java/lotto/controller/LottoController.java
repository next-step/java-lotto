package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.domain.LottoGenerator.generateLottos;

public class LottoController {

    public void buyLotto() {
        Fee fee = InputView.payForGames();
        Lottos lottos = generateLottos(fee);
        ResultView.showLottos(lottos);
        Lotto winningNumber = Lotto.from(InputView.inputWinningNumber());
        LottoMatchLogic lottoMatchLogic = new LottoMatchLogic(lottos);
        ResultView.showRanks(lottoMatchLogic.checkRank(winningNumber, fee));
    }
}
