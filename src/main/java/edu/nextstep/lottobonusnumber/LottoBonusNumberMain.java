package edu.nextstep.lottobonusnumber;

import edu.nextstep.lottobonusnumber.utils.Calculator;
import edu.nextstep.lottobonusnumber.view.ResultView;
import edu.nextstep.lottobonusnumber.domain.*;
import edu.nextstep.lottobonusnumber.domain.numbersmaker.AutoNumbersMaker;
import edu.nextstep.lottobonusnumber.domain.numbersmaker.CustomNumbersMaker;
import edu.nextstep.lottobonusnumber.view.InputView;

import java.util.Map;

public class LottoBonusNumberMain {

    public static void main(String[] args) {

        int inputPayment = InputView.inputPayment();
        Payment payment = new Payment(inputPayment);

        Tickets tickets = Tickets.of(payment, new AutoNumbersMaker());

        ResultView.printTickets(tickets);

        String winningNumbers = InputView.inputWinningNumbers();
        Ticket winningTicket = Ticket.madeBy(new CustomNumbersMaker(winningNumbers));

        int inputBonusNumber = InputView.inputBonusNumber();
        BonusNumber bonusNumber = BonusNumber.of(inputBonusNumber, winningTicket);

        Map<Prize,Integer> winningResult = tickets.checkWinningResult(winningTicket, bonusNumber);
        double rateOfReturn = Calculator.calculateRateOfReturn(winningResult, payment);

        ResultView.printWinningResult(winningResult, rateOfReturn);
    }
}
