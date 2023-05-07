package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoStatisticsDto;
import lotto.dto.ManualLottoTicketsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualPurchaseCount = InputView.inputManualPurchaseCount();
        int autoPurchaseCount = calculateAutoPurchaseCount(manualPurchaseCount, purchaseAmount);
        validateManualPurchaseCount(manualPurchaseCount, purchaseAmount);
        List<List<Integer>> tickets = InputView.inputManualPurchaseTickets(manualPurchaseCount);
        lottoTicketMachine.createManualLottoTickets(tickets);
        lottoTicketMachine.createAutoLottoTickets(autoPurchaseCount);

        OutputView.outputManualLottoNumbers(ManualLottoTicketsDto.from(
                lottoTicketMachine.getLottoTicketsTotal(),
                manualPurchaseCount,
                autoPurchaseCount
        ));

        List<Integer> winningNumbers = InputView.inputLastWinningNumber();
        LottoNumber bonusBallNumber = LottoNumber.of(InputView.inputBonusBallNumber());
        WinningTicket winningTicket
                = new WinningTicket(winningNumbers, bonusBallNumber);
        OutputView.outputLottoStatistics(calculateLottoStatistics(lottoTicketMachine, winningTicket));
    }

    private static int calculateAutoPurchaseCount(int manualPurchaseCount, int purchaseAmount) {
        return (purchaseAmount - LottoTicketMachine.LOTTO_PRICE * manualPurchaseCount)
                / LottoTicketMachine.LOTTO_PRICE;
    }

    private static void validateManualPurchaseCount(int manualPurchaseCount, int purchaseAmount) {
        if (purchaseAmount < manualPurchaseCount * LottoTicketMachine.LOTTO_PRICE) {
            throw new IllegalArgumentException("구입할 금액을 초과합니다.");
        }
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
