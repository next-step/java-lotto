package lotto.controller;

import lotto.domain.model.MatchResult;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoWallet;
import lotto.domain.service.LottoMachine;


public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());

    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoWallet lottoWallet = purchase(purchaseAmount);
        draw(lottoWallet, purchaseAmount);
    }

    private LottoWallet purchase(int purchaseAmount) {
        LottoWallet lottoWallet = this.lottoMachine.buyLottos(purchaseAmount);
        ResultView.printPurchasedLottos(lottoWallet);
        return lottoWallet;
    }

    private void draw(LottoWallet lottoWallet, int purchaseAmount) {
        LottoNumbers winNumbers = new LottoNumbers(InputView.getWinNumbers());
        int bonusNumber = InputView.getBonusNumber();
        MatchResult result = lottoWallet.countMatches(winNumbers, bonusNumber);
        ResultView.printMatchResult(result, purchaseAmount);
    }
}
