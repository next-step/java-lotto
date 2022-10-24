package lotto;

import java.util.ArrayList;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.lottomachine.AutomaticLottoMachine;
import lotto.domain.lottomachine.LottoMachine;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningTicket;
import lotto.domain.winner.WinningReport;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class Lotto {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = new PurchasePrice(LottoInputView.insertPurchasePrice());

        PurchasePrice manualLottoPurchasePrice = new PurchasePrice(Ticket.getPrice() * LottoInputView.insertManualLottoCount());
        PurchasePrice automaticLottoPurchasePrice = PurchasePrice.subtractPrice(purchasePrice, manualLottoPurchasePrice);

        LottoMachine manualLottoMachine = LottoInputView.insertManualLottoNumbers(manualLottoPurchasePrice);
        LottoMachine automaticLottoMachine = new AutomaticLottoMachine();

        TicketBox manualTicketBox = getManualTicketBox(manualLottoPurchasePrice, manualLottoMachine);
        TicketBox automaticTicketBox = getManualTicketBox(automaticLottoPurchasePrice, automaticLottoMachine);
        TicketBox ticketBox = TicketBox.merge(manualTicketBox, automaticTicketBox);

        printTickets(manualTicketBox, automaticTicketBox, ticketBox);
        printResult(purchasePrice, ticketBox);
    }

    private static TicketBox getManualTicketBox(PurchasePrice purchasePrice, LottoMachine lottoMachine) {
        if (purchasePrice.getPrice() == 0) {
            return new TicketBox(new ArrayList<>());
        }
        return lottoMachine.issueTickets(purchasePrice);
    }

    private static void printTickets(TicketBox manualTicketBox, TicketBox automaticTicketBox, TicketBox ticketBox) {
        LottoResultView.printTicketCount(manualTicketBox.getSize(), automaticTicketBox.getSize());
        LottoResultView.printTickets(ticketBox);
    }

    private static void printResult(PurchasePrice purchasePrice, TicketBox ticketBox) {
        WinningTicket winningNumbers = LottoInputView.insertWinnerNumbers();
        WinningReport winningReport = new WinningReport();

        winningReport.updateReport(ticketBox, winningNumbers);
        LottoResultView.printResultStatics(winningReport, purchasePrice);
    }

}
