package lotto;

import lotto.domain.*;
import lotto.strategy.AutoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryGame {
    private Price price;
    private LotteryTickets tickets;

    public void start() {
        buyTickets();
        calculateRank();
    }

    private void buyTickets() {
        price = new Price(InputView.enterPurchasePrice());
        Amount amountOfTickets = price.calculateAmount();

        Amount amountOfManualTickets = new Amount(InputView.enterAmountOfManualTickets());
        tickets = LotteryTickets.of(InputView.enterManualTickets(amountOfManualTickets));

        Amount amountOfAutoTickets = amountOfTickets.minus(amountOfManualTickets);
        tickets.add(amountOfAutoTickets.createTickets(new AutoGenerateStrategy()));

        OutputView.printAmountOfTickets(amountOfManualTickets, amountOfAutoTickets);
        OutputView.printBuyingTickets(tickets);
    }

    private void calculateRank() {
        WinningTicket winningTicket = new WinningTicket(InputView.enterWinningNumbers(), InputView.enterBonusBoll());

        Ranks ranks = tickets.calculateRanks(winningTicket);
        Double rateOfRank = ranks.calculateRateOfReturn(price);
        Result result = new Result(ranks, rateOfRank);

        OutputView.printResult(result);
    }
}
