package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int purchaseAmount = InputView.purchaseAmount();
        List<String> manuallyPickedLottoTickets = InputView.manuallyPickedLottoTicket();
        LottoPurchaseInformation purchaseInfo = LottoPurchaseInformation.of(purchaseAmount, manuallyPickedLottoTickets);
        OutputView.printNumberOfPurchase(purchaseInfo);
        LottoTickets lottoTickets = LottoMachine.generateLottoTickets(purchaseInfo);
        OutputView.printLottoNumbers(lottoTickets);
        LottoWinningNumbers lottoWinningNumbers = InputView.inputLottoWinningNumbers();
        LottoTicketsWinInformation lottoTicketsWinInformation = lottoTickets.winInformation(lottoWinningNumbers, purchaseInfo.lottoTicketsPrice());
        Map<LottoRank, Integer> winningStaticsMap = lottoTicketsWinInformation.winningStatics();
        OutputView.printWinningStatics(winningStaticsMap);
        double earningRate = lottoTicketsWinInformation.earningRate();
        OutputView.earningRate(earningRate);
    }


}
