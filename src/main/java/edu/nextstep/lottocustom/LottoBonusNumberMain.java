package edu.nextstep.lottocustom;

import edu.nextstep.lottocustom.domain.*;
import edu.nextstep.lottocustom.domain.numbersmaker.AutoNumbersMaker;
import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import edu.nextstep.lottocustom.utils.Calculator;
import edu.nextstep.lottocustom.view.InputView;
import edu.nextstep.lottocustom.view.ResultView;

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
