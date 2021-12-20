package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    public void execute() {
        String purchaseAmount = InputView.purchaseAmount();
        LottoTickets lottoTickets = LottoTicketFactory.buy(purchaseAmount);
        printNumberOfPurchase(lottoTickets);
        printLottoTickets(lottoTickets);
        LottoWinningNumbers lottoWinningNumbers = inputLottoWinningNumbers();
        printLottoWinInformation(lottoTickets, lottoWinningNumbers);
    }

    private void printNumberOfPurchase(LottoTickets lottoTickets) {
        int numberOfPurchase = lottoTickets.size();
        OutputView.printNumberOfPurchase(numberOfPurchase);
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
