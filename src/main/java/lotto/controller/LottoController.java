package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoStatisticsDto;
import lotto.dto.ManualLottoTicketsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualPurchaseCount = InputView.inputManualPurchaseCount();
        List<List<Integer>> tickets = InputView.inputManualPurchaseTickets(manualPurchaseCount);
        LottoTicketMachine lottoTicketMachine
                = new LottoTicketMachine(manualPurchaseCount, purchaseAmount);
        lottoTicketMachine.createLottoTickets(tickets);

        OutputView.outputManualLottoNumbers(ManualLottoTicketsDto.from(
                lottoTicketMachine.getLottoTicketsTotal(),
                manualPurchaseCount,
                lottoTicketMachine.getAutoPurchaseCount()
        ));

        List<Integer> winningNumbers = InputView.inputLastWinningNumber();
        LottoNumber bonusBallNumber = LottoNumber.of(InputView.inputBonusBallNumber());
        WinningTicket winningTicket
                = new WinningTicket(winningNumbers, bonusBallNumber);
        OutputView.outputLottoStatistics(calculateLottoStatistics(lottoTicketMachine, winningTicket));
    }

    private static LottoStatisticsDto calculateLottoStatistics(LottoTicketMachine lottoTicketMachine,
                                                        WinningTicket winningTicket) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        LottoTickets lottoTicketsTotal = lottoTicketMachine.getLottoTicketsTotal();
        return new LottoStatisticsDto(
                lottoStatistics.calculateMatchingCounts(lottoTicketsTotal, winningTicket),
                lottoStatistics.calculateGrossRateOfEarnings(lottoTicketsTotal.getSize())
        );
    }
}
