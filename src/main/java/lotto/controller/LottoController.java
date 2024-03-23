package lotto.controller;

import lotto.domain.Fee;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    public void buyLotto() {
        Fee fee = InputView.payForGames();
        Lottos lottos = lottoGenerator.generateLottos(fee);
        ResultView.showLottos(lottos);

    }
}
