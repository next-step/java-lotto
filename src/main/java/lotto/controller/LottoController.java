package lotto.controller;

import lotto.domain.*;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int purchaseAmount = InputView.purchaseAmount();
        int numberOfLottoTicket = purchaseAmount / 1000;
        int numberOfManuallyPickedLottoTicket = InputView.numberOfManuallyPickedLottoTicket();
        if (numberOfLottoTicket < numberOfManuallyPickedLottoTicket) {
            throw new LottoException("로또 수동 입력 개수가 구입 금액을 초과했습니다");
        }
        List<LottoTicket> manuallyPickedLottoTickets = InputView.manuallyPickedLottoTicket(numberOfManuallyPickedLottoTicket);
        LottoTickets lottoTickets = LottoTicketFactory.buy(numberOfLottoTicket, numberOfManuallyPickedLottoTicket, manuallyPickedLottoTickets);
        printNumberOfPurchase(lottoTickets, numberOfManuallyPickedLottoTicket);
        printLottoTickets(lottoTickets);
        LottoWinningNumbers lottoWinningNumbers = inputLottoWinningNumbers();
        printLottoWinInformation(lottoTickets, lottoWinningNumbers);
    }

    private void printNumberOfPurchase(LottoTickets lottoTickets, int numberOfManuallyPickedLottoTicket) {
        int numberOfAutomaticallyPickedLottoTicket = lottoTickets.size();

        OutputView.printNumberOfPurchase(numberOfManuallyPickedLottoTicket, numberOfAutomaticallyPickedLottoTicket);
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
