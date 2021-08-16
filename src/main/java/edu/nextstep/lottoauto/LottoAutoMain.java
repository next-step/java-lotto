package edu.nextstep.lottoauto;

import edu.nextstep.lottoauto.form.WinningResultForm;
import edu.nextstep.lottoauto.manager.TicketManager;
import edu.nextstep.lottoauto.ticketmaker.AutoTicketMaker;
import edu.nextstep.lottoauto.ticketmaker.TicketMaker;
import edu.nextstep.lottoauto.view.InputView;
import edu.nextstep.lottoauto.view.ResultView;

public class LottoAutoMain {
    public static void main(String[] args) {
        int payment = InputView.inputPayment();

        TicketManager ticketManager = new TicketManager();
        TicketMaker ticketMaker = new AutoTicketMaker();
        ticketManager.createAndSaveTickets(payment, ticketMaker);

        ResultView.printTickets(ticketManager.findTickets());

        String winningNumbersOfString = InputView.inputWinningNumbers();

        WinningResultForm winningResult = ticketManager.confirmWinningResult(winningNumbersOfString);

        ResultView.printWinningResult(winningResult);
    }
}
