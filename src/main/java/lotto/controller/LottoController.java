package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

import static lotto.domain.LottoNumber.lottoNumbers;

public class LottoController {

    public void lottoGame() {
        Input input = new Input();
        Payment payment = new Payment(input.amount());

        List<Lotto> lottoTickets = new LottoMachine(lottoNumbers()).issue(payment);
        Output.printBuyCount(payment.count());
        Output.printBuyTickets(lottoTickets);
        WinningNumber winningNumber = new WinningNumber(input.winningNumberOfLastWeek(), input.bonusNumberOfLastWeek());

        ResultStats resultStats = new ResultStats(lottoTickets, winningNumber);
        Output.printLottoResult(resultStats.countPerPrize());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(payment.amount()));
    }
}
