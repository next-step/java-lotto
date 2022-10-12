package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.ResultStats;
import lotto.domain.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void lottoGame() {
        Input input = new Input();
        Lotto lotto = new Lotto();
        Payment payment = new Payment(input.amount());

        lotto.issue(payment);
        Output.printBuyCount(payment.amount());
        Output.printBuyTickets(lotto.lottoTickets());

        ResultStats resultStats = new ResultStats(lotto.matchingCountsByTickets(new WinningNumber(input.winningNumberOfLastWeek()).winningNumber()));
        Output.printLottoResult(resultStats.countsOfPrizes());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(payment.amount()));
    }
}
