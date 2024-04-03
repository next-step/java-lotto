package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.domain.LottoGenerator.generateLottos;

public class LottoController {

    public void buyLotto() {

        LottoFee lottoFee = InputView.payForGames();
        Lottos lottos = generateLottos(lottoFee);
        ResultView.showLottos(lottos);


        Lotto winningNumber = Lotto.from(InputView.inputWinningNumber());
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLottoNumber = new WinningLotto(winningNumber, bonusNumber);

        ResultView.showRanks(lottos.match(winningLottoNumber), lottoFee);
    }
}
