package lotto.controller;

import lotto.domain.model.*;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.domain.service.LottoMachine;

import java.util.List;


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
        List<LottoNumber> winNumbers = InputView.getWinNumbers();
        LottoNumber bonusNumber = InputView.getBonusNumber();
        WinningTicket winningTicket = new WinningTicket(winNumbers, bonusNumber);

        MatchResult result = lottoWallet.countMatches(winningTicket);
        ResultView.printMatchResult(result, purchaseAmount);
    }
}
