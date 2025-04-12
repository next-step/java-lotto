package lotto.controller;

import lotto.domain.generator.LottoTicketGenerator;
import lotto.domain.generator.RandomLottoTicketGenerator;
import lotto.domain.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.domain.service.LottoMachine;

import java.util.List;


public class LottoController {
    public void run() {
        LottoRequest request = InputView.getLottoRequest();
        LottoWallet lottoWallet = purchase(request);

        List<Integer> winNumbers = InputView.getWinNumbers();
        int bonusNumber = InputView.getBonusNumber();
        int purchaseAmount = request.getPurchaseAmount();
        draw(winNumbers, bonusNumber, lottoWallet, purchaseAmount);
    }

    private LottoWallet purchase(LottoRequest request) {
        LottoTicketGenerator lottoTicketGenerator = new RandomLottoTicketGenerator();
        LottoWallet lottoWallet = LottoMachine.buy(lottoTicketGenerator, request);
        ResultView.printPurchasedLottos(lottoWallet, request.getAutomaticLottosCount(), request.getManualLottosCount());
        return lottoWallet;
    }

    private void draw(List<Integer> winNumbers, int bonusNumber, LottoWallet lottoWallet, int purchaseAmount) {
        WinningTicket winningTicket = new WinningTicket(winNumbers, bonusNumber);

        MatchResult result = lottoWallet.countMatches(winningTicket);
        ResultView.printMatchResult(result, purchaseAmount);
    }
}
