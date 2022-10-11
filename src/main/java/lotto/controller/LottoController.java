package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.ResultStats;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void lottoGame() {
        User user = new User();
        Input input = new Input();
        Lotto lotto = new Lotto(input.payment());

        user.receiveTickets(lotto.tickets());
        Output.printBuyCount(lotto.payment());
        Output.printBuyTickets(user.lottoTickets());

        ResultStats resultStats = new ResultStats(user.matchingCountsByTickets(new WinningNumber(input.winningNumberOfLastWeek()).winningNumber()));
        Output.printLottoResult(resultStats.countsOfPrizes());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(lotto.payment()));
    }
}
