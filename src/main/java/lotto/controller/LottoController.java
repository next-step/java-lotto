package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.ResultStats;
import lotto.domain.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void lottoGame() {
        Input input = new Input();
        Lotto lotto = new Lotto(input.payment());

        lotto.issue();
        Output.printBuyCount(lotto.payment());
        Output.printBuyTickets(lotto.lottoTickets());

        ResultStats resultStats = new ResultStats(lotto.matchingCountsByTickets(new WinningNumber(input.winningNumberOfLastWeek()).winningNumber()));
        Output.printLottoResult(resultStats.countsOfPrizes());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(lotto.payment()));
    }
}
