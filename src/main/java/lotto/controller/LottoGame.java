package lotto.controller;

import lotto.domain.*;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.util.List;

public class LottoGame {
    public LottoGame() { }

    public List<Lotto> generateLotto(PrePurchaseInformation prePurchaseInformation) {
        return LottoGenerator.generate(prePurchaseInformation);
    }

    public PrePurchaseInformation generatePrePurchaseInformation(String amountValue, String manualValue) {
        Amount amount = new Amount(amountValue, manualValue);
        String values = InputView.manualBuyNumbers(amount.manualQuantity());
        return new PrePurchaseInformation(amount, values);
    }

    public void start() {
        String amountValue = InputView.amount();
        String manualValue = InputView.manualBuyQuantity();

        PrePurchaseInformation prePurchaseInformation = generatePrePurchaseInformation(amountValue, manualValue);
        List<Lotto> lottos = generateLotto(prePurchaseInformation);
        ResultView.showPurchaseLotto(lottos);

        String winningNumbers = InputView.winningNumbers();
        String bonusNumber = InputView.bonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LotteryMachine lotteryMachine = new LotteryMachine(winningLotto, prePurchaseInformation.amount());
        LottoResult lottoResult = lotteryMachine.result(lottos);

        ResultView.showWinningResult(lottoResult);
    }
}
