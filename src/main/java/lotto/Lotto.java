package lotto;

import lotto.domain.AutomaticLottoMachine;
import lotto.domain.LottoMachine;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.number.WinningTicket;
import lotto.domain.winner.WinningReport;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class Lotto {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = new PurchasePrice(LottoInputView.insertPurchasePrice());

        LottoMachine lottoMachine = new AutomaticLottoMachine();
        TicketBox ticketBox = lottoMachine.issueTickets(purchasePrice);
        LottoResultView.printTicketCount(ticketBox.getSize());
        LottoResultView.printTickets(ticketBox);

        WinningTicket winningNumbers = LottoInputView.insertWinnerNumbers();
        WinningReport winningReport = new WinningReport();

        winningReport.updateReport(ticketBox, winningNumbers);
        LottoResultView.printResultStatics(winningReport, purchasePrice);
    }

}
