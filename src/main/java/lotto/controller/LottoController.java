package lotto.controller;

import lotto.domain.model.*;
import lotto.domain.generator.RandomLottoTicketGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.domain.service.LottoMachine;

import java.util.List;


public class LottoController {
    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();
        List<List<Integer>> manualNumbersList = InputView.getManualNumbersList(manualLottoCount);
        LottoWallet lottoWallet = purchase(purchaseAmount, manualNumbersList);

        List<Integer> winNumbers = InputView.getWinNumbers();
        int bonusNumber = InputView.getBonusNumber();
        draw(winNumbers, bonusNumber, lottoWallet, purchaseAmount);
    }

    private LottoWallet purchase(int purchaseAmount, List<List<Integer>> manualNumbersList) {
        LottoWallet lottoWallet = new LottoWallet();
        LottoMachine lottoMachine = new LottoMachine(new RandomLottoTicketGenerator(), purchaseAmount);

        List<LottoTicket> manualLottos = lottoMachine.buyManualLottos(manualNumbersList);
        lottoWallet.addLottos(manualLottos);

        List<LottoTicket> automaticLottos = lottoMachine.buyAutomaticLottos();
        lottoWallet.addLottos(automaticLottos);

        ResultView.printPurchasedLottos(lottoWallet, manualNumbersList.size(), automaticLottos.size());
        return lottoWallet;
    }

    private void draw(List<Integer> winNumbers, int bonusNumber, LottoWallet lottoWallet, int purchaseAmount) {
        WinningTicket winningTicket = new WinningTicket(winNumbers, bonusNumber);

        MatchResult result = lottoWallet.countMatches(winningTicket);
        ResultView.printMatchResult(result, purchaseAmount);
    }
}
