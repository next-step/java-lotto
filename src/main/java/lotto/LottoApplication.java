package lotto;

import lotto.domain.*;
import lotto.view.LottoMachineResultView;
import lotto.view.LottoMachineInputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();

        machine.purchaseTotalTicket(LottoMachineInputView.lottoPurchaseView());
        int manualCount = machine.purchaseManualTicket(LottoMachineInputView.lottoManualPurchaseView());
        List<LottoTicket> manualTickets = LottoMachineInputView.insertManualNumbersView(manualCount);

        LottoTickets lottoTickets = machine.myTickets(manualTickets);
        LottoMachineResultView.showTicketNumber(lottoTickets);

        LottoTicket winningLottoTicket = new LottoTicket(LottoMachineInputView.latestWinningLotto());
        winningLottoTicket.bonusNumber(LottoMachineInputView.bonusLottoNumber());
        LottoMachineResultView.printLottoResult(LottoMachine.winningResult(winningLottoTicket, lottoTickets));

    }
}
