package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        Money purchasedAmount = InputView.acceptPuchaseAmount();
        Lottos purchasedLottos = createLottos(purchasedAmount.getLottoCount());
        ResultView.printInput(purchasedLottos, purchasedAmount);
        WinningLotto winningLotto = InputView.acceptWinningLotto();

        Result result = winningLotto.makeResult(purchasedLottos);

        ResultView.printResult(purchasedAmount, result);
    }

    private Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
