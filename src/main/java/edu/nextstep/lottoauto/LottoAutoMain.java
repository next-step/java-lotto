package edu.nextstep.lottoauto;

import edu.nextstep.lottoauto.domain.TicketMachine;
import edu.nextstep.lottoauto.domain.TicketRepository;
import edu.nextstep.lottoauto.domain.WinningCheckMachine;
import edu.nextstep.lottoauto.exception.CustomException;
import edu.nextstep.lottoauto.view.form.WinningResultForm;
import edu.nextstep.lottoauto.domain.ticketmaker.AutoNumbersMaker;
import edu.nextstep.lottoauto.domain.ticketmaker.NumbersMaker;
import edu.nextstep.lottoauto.view.InputView;
import edu.nextstep.lottoauto.view.ResultView;

public class LottoAutoMain {
    public static void main(String[] args) {
        try {
            int payment = InputView.inputPayment();
            NumbersMaker numbersMaker = new AutoNumbersMaker();
            TicketMachine.createAndSaveTickets(payment, numbersMaker);

            ResultView.printTickets(TicketRepository.findAll());

            String winningNumbersOfString = InputView.inputWinningNumbers();

            WinningResultForm winningResult = WinningCheckMachine.confirmWinningResult(winningNumbersOfString);

            ResultView.printWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
