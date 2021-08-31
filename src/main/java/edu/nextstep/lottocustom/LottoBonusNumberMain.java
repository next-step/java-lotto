package edu.nextstep.lottocustom;

import edu.nextstep.lottocustom.domain.*;
import edu.nextstep.lottocustom.domain.numbersmaker.AutoNumbersMaker;
import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import edu.nextstep.lottocustom.exception.CustomException;
import edu.nextstep.lottocustom.view.InputView;
import edu.nextstep.lottocustom.view.ResultView;

import java.util.List;

public class LottoBonusNumberMain {

    public static void main(String[] args) {
        try {
            Payment payment = new Payment(InputView.inputPayment());

            int numberOfCustomTickets = InputView.inputNumberOfCustomTickets();
            payment.validateOverPossibleTickets(numberOfCustomTickets);
            List<String> customNumbersString = InputView.inputCustomNumbers(numberOfCustomTickets);

            Tickets tickets = Tickets.of(payment, customNumbersString, new AutoNumbersMaker());

            ResultView.printTickets(tickets);

            Ticket firstPrizeTicket =
                    Ticket.madeBy(new CustomNumbersMaker(InputView.inputWinningNumbers()));

            LottoNumber bonusNumber =
                    LottoNumber.of(InputView.inputBonusNumber());

            WinningTicket winningTicket = new WinningTicket(firstPrizeTicket, bonusNumber);

            WinningResult winningResult = tickets.checkWinningResult(winningTicket);

            ResultView.printWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
