package edu.nextstep.lottocustom;

import edu.nextstep.lottocustom.domain.*;
import edu.nextstep.lottocustom.domain.numbersmaker.AutoNumbersMaker;
import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import edu.nextstep.lottocustom.exception.CustomException;
import edu.nextstep.lottocustom.utils.Calculator;
import edu.nextstep.lottocustom.view.InputView;
import edu.nextstep.lottocustom.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoBonusNumberMain {

    public static void main(String[] args) {
        try {
            Payment payment = new Payment(InputView.inputPayment());

            int numberOfCustomTickets = InputView.inputNumberOfCustomTickets();
            payment.validateOverPossibleTickets(numberOfCustomTickets);
            List<String> customNumbersString = InputView.inputCustomNumbers(numberOfCustomTickets);

            Tickets tickets = Tickets.of(payment, numberOfCustomTickets, customNumbersString, new AutoNumbersMaker());

            ResultView.printTickets(tickets);

            Ticket firstPrizeTicket =
                    Ticket.madeBy(new CustomNumbersMaker(InputView.inputWinningNumbers()));

            LottoNumber bonusNumber =
                    LottoNumber.of(InputView.inputBonusNumber());

            WinningTicket winningTicket = new WinningTicket(firstPrizeTicket, bonusNumber);

            Map<Prize, Integer> winningResult = tickets.checkWinningResult(winningTicket);
            double rateOfReturn = Calculator.calculateRateOfReturn(winningResult, payment);

            ResultView.printWinningResult(winningResult, rateOfReturn);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
