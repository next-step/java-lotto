package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.TicketBox;
import lotto.domain.number.WinningNumbers;
import lotto.domain.winner.WinningReport;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class Lotto {

    public static void main(String[] args) {
        int purchasePrice = LottoInputView.insertPurchasePrice();

        TicketBox ticketBox = LottoMachine.getAutomaticTickets(purchasePrice);
        LottoResultView.printTicketCount(ticketBox.getSize());
        LottoResultView.printTickets(ticketBox);

        WinningNumbers winningNumbers = LottoInputView.insertWinnerNumbers();
        WinningReport winningReport = new WinningReport();

        winningReport.updateReport(ticketBox, winningNumbers);
        LottoResultView.printResultStatics(winningReport, purchasePrice);
    }

}
