package lotto.controller;

import lotto.domain.*;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.util.List;

public class LottoGame {

    public LottoGame() { }

    public List<Lotto> generateLotto(Amount amount) {
        return LottoGenerator.generate(amount.quantity());
    }

    public Amount generateAmount(String value) {
        return new Amount(Integer.parseInt(value));
    }

    public void start() {
        Amount purchaseAmount = generateAmount(InputView.amount());
        List<Lotto> lottos = generateLotto(purchaseAmount);
        ResultView.showPurchaseLotto(lottos);

        String winningNumbers = InputView.winningNumbers();
        String bonusNumber = InputView.bonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LotteryMachine lotteryMachine = new LotteryMachine(winningLotto, purchaseAmount);
        LottoResult lottoResult = lotteryMachine.result(lottos);

        ResultView.showWinningResult(lottoResult);
    }
}
