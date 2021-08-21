package edu.nextstep.lottobonusnumber;

import edu.nextstep.lottobonusnumber.domain.*;
import edu.nextstep.lottobonusnumber.domain.ticketmaker.AutoNumbersMaker;
import edu.nextstep.lottobonusnumber.domain.ticketmaker.NumbersMaker;
import edu.nextstep.lottobonusnumber.exception.CustomException;
import edu.nextstep.lottobonusnumber.view.InputView;
import edu.nextstep.lottobonusnumber.view.ResultView;
import edu.nextstep.lottobonusnumber.view.form.WinningResultForm;

import java.util.List;

public class LottoAutoMain {
    public static void main(String[] args) {
        TicketRepository ticketRepository = new TicketRepository();

        try {
            int payment = InputView.inputPayment();
            NumbersMaker numbersMaker = new AutoNumbersMaker();
            ticketRepository.saveAll(TicketMachine.createTickets(payment, numbersMaker));

            List<Ticket> tickets= ticketRepository.findAll();
            ResultView.printTickets(tickets);

            String winningNumbersOfString = InputView.inputWinningNumbers();

            int bonusNumber = InputView.inputBonusNumber();

            WinningTicket winningTicket = WinningTicket.of(winningNumbersOfString, bonusNumber);

            WinningResultForm winningResult =
                    WinningCheckMachine.confirmWinningResult(tickets, winningTicket);

            ResultView.printWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
