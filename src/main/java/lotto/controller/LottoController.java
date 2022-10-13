package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.ResultStats;
import lotto.domain.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.lottoNumbers;

public class LottoController {

    public void lottoGame() {
        Input input = new Input();
        Lotto lotto = new Lotto(lottoNumbers());
        Payment payment = new Payment(input.amount());

        List<Lotto> lottoTickets = lotto.issue(payment);
        Output.printBuyCount(payment.count());
        Output.printBuyTickets(lottoTickets);

        Lotto winningNumber = new WinningNumber(input.winningNumberOfLastWeek()).winningNumber();
        ResultStats resultStats = new ResultStats(lottoTickets.stream()
                .map(ticket -> ticket.compareNumber(winningNumber))
                .collect(Collectors.toList()));
        Output.printLottoResult(resultStats.countsOfPrizes());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(payment.amount()));
    }
}
