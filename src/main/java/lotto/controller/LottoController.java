package lotto.controller;

import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoNumber;
import lotto.domain.WinningTicket;
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
        OutputView.outputLottoStatistics(lottoTicketMachine.calculateLottoStatistics(winningTicket));
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
}
