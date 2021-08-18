package edu.nextstep.lottoauto;

import edu.nextstep.lottoauto.exception.CustomException;
import edu.nextstep.lottoauto.view.form.WinningResultForm;
import edu.nextstep.lottoauto.domain.TicketManager;
import edu.nextstep.lottoauto.domain.ticketmaker.AutoNumbersMaker;
import edu.nextstep.lottoauto.domain.ticketmaker.NumbersMaker;
import edu.nextstep.lottoauto.view.InputView;
import edu.nextstep.lottoauto.view.ResultView;

public class LottoAutoMain {
    public static void main(String[] args) {
        try {
            int payment = InputView.inputPayment();

            TicketManager ticketManager = new TicketManager();
            NumbersMaker numbersMaker = new AutoNumbersMaker();
            ticketManager.createAndSaveTickets(payment, numbersMaker);

            ResultView.printTickets(ticketManager.findTickets());

            String winningNumbersOfString = InputView.inputWinningNumbers();

            WinningResultForm winningResult = ticketManager.confirmWinningResult(winningNumbersOfString);

            ResultView.printWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
