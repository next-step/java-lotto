package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        Money purchasedAmount = InputView.acceptPuchaseAmount();
        List<Lotto> lottos = makeLottos(purchasedAmount.getLottoCount());
        ResultView.printInput(lottos, purchasedAmount);
        WinningNumber winningNumber = InputView.acceptWinningNumber();

        Lottos purchasedLottos = new Lottos(lottos);
        Result result = purchasedLottos.makeResult(winningNumber);

        ResultView.printResult(purchasedAmount, result);
    }

    private List<Lotto> makeLottos(int purchasedCount) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < purchasedCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return lottos;
    }
}
