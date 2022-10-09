package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.NavigableSet;

public class LottoController {

    public void lottoGame() {
        User user = new User(new UserInput(new Input().price()));
        user.receiveTickets(new Lotto().lotto(user.userInput()));
        Output.printBuyCount(user.userInput().count());
        Output.printBuyTickets(user.lottoTickets());

        final NavigableSet<Integer> raffleNumbers = new LottoRaffle().raffleNumbers();
        Output.printRaffleResult(raffleNumbers);

        ResultStats resultStats = new ResultStats(user.matchingCountsByTickets(raffleNumbers));
        Output.printLottoResult(resultStats.countsOfPrizes());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(user.userInput().price()));
    }
}
