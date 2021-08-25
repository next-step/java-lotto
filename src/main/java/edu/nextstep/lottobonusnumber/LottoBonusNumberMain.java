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

        Payment payment = new Payment(InputView.inputPayment());

        Tickets tickets = Tickets.of(payment, new AutoNumbersMaker());

        ResultView.printTickets(tickets);

        Ticket firstPrizeTicket =
                Ticket.madeBy(new CustomNumbersMaker(InputView.inputWinningNumbers()));

        LottoNumber bonusNumber =
                LottoNumber.of(InputView.inputBonusNumber());

        WinningTicket winningTicket = new WinningTicket(firstPrizeTicket, bonusNumber);

        Map<Prize,Integer> winningResult = tickets.checkWinningResult(winningTicket);
        double rateOfReturn = Calculator.calculateRateOfReturn(winningResult, payment);

        ResultView.printWinningResult(winningResult, rateOfReturn);
    }
}
