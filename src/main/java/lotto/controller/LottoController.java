package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        String purchaseAmount = InputView.purchaseAmount();
        LottoTickets lottoTickets = LottoTicketFactory.buy(purchaseAmount);
        printNumberOfPurchase(lottoTickets);
        printLottoTickets(lottoTickets);
        LottoWinningNumbers lottoWinningNumbers = inputLottoWinningNumbers();
        printLottoWinningStatics(lottoTickets, lottoWinningNumbers);
        printEarningRate(lottoTickets, lottoWinningNumbers);

    }

    private void printNumberOfPurchase(LottoTickets lottoTickets) {
        int numberOfPurchase = lottoTickets.size();
        OutputView.printNumberOfPurchase(numberOfPurchase);
    }

    private void printLottoTickets(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTicketList) {
            OutputView.printLottoNumbers(lottoTicket.getLottoNumbers());
        }
    }

    private LottoWinningNumbers inputLottoWinningNumbers() {
        String winningLottoTicketNumber = InputView.winningLottoTicketNumber();
        String bonusNumber = InputView.bonusNumber();
        return LottoWinningNumbers.from(winningLottoTicketNumber, bonusNumber);
    }

    private void printLottoWinningStatics(LottoTickets lottoTickets, LottoWinningNumbers lottoWinningNumbers) {
        Map<LottoRank, Integer> map = lottoTickets.winningStatics(lottoWinningNumbers);
        OutputView.printWinningStatics(map);
    }

    private void printEarningRate(LottoTickets lottoTickets, LottoWinningNumbers lottoWinningNumbers) {
        double earningRate = lottoTickets.earningRate(lottoWinningNumbers);
        OutputView.earningRate(earningRate);
    }

}
