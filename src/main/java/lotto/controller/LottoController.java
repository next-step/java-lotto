package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int purchaseAmount = InputView.purchaseAmount();
        int numberOfManuallyPickedLottoTicket = InputView.numberOfManuallyPickedLottoTicket();
        LottoPurchaseInformation lottoPurchaseInformation = LottoPurchaseInformation.of(purchaseAmount, numberOfManuallyPickedLottoTicket);
        List<LottoTicket> manuallyPickedLottoTickets = InputView.manuallyPickedLottoTicket(numberOfManuallyPickedLottoTicket);
        LottoTickets lottoTickets = LottoTicketFactory.buy(lottoPurchaseInformation, manuallyPickedLottoTickets);
        OutputView.printNumberOfPurchase(lottoPurchaseInformation);
        printLottoTickets(lottoTickets);
        LottoWinningNumbers lottoWinningNumbers = inputLottoWinningNumbers();
        printLottoWinInformation(lottoTickets, lottoWinningNumbers);
    }



    private void printLottoTickets(LottoTickets lottoTickets) {
        OutputView.printLottoNumbers(lottoTickets);
    }

    private LottoWinningNumbers inputLottoWinningNumbers() {
        String winningLottoTicketNumber = InputView.winningLottoTicketNumber();
        String bonusNumber = InputView.bonusNumber();
        return LottoWinningNumbers.from(winningLottoTicketNumber, bonusNumber);
    }

    private void printLottoWinInformation(LottoTickets lottoTickets, LottoWinningNumbers lottoWinningNumbers) {
        LottoTicketsWinInformation lottoTicketsWinInformation = LottoTicketsWinInformation.from(lottoTickets);
        Map<LottoRank, Integer> winningStaticsMap = lottoTicketsWinInformation.winningStatics(lottoWinningNumbers);
        OutputView.printWinningStatics(winningStaticsMap);
        double earningRate = lottoTicketsWinInformation.earningRate(lottoWinningNumbers);
        OutputView.earningRate(earningRate);

    }

}
