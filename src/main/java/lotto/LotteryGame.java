package lotto;

import lotto.domain.*;
import lotto.strategy.AutoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryGame {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private Price price;
    private LotteryTickets tickets;

    public void start() {
        buyTickets();
        calculateRank();
    }

    private void buyTickets() {
        price = new Price(inputView.enterPurchasePrice());
        Amount amountOfTickets = price.calculateAmount();

        Amount amountOfManualTickets = new Amount(inputView.enterAmountOfManualTickets());
        tickets = LotteryTickets.of(inputView.enterManualTickets(amountOfManualTickets));

        Amount amountOfAutoTickets = amountOfTickets.minus(amountOfManualTickets);
        tickets.add(amountOfAutoTickets.createTickets(new AutoGenerateStrategy()));

        outputView.printAmountOfTickets(amountOfManualTickets, amountOfAutoTickets);
        outputView.printBuyingTickets(tickets);
    }

    private void calculateRank() {
        WinningTicket winningTicket = new WinningTicket(inputView.enterWinningNumbers(), inputView.enterBonusBoll());

        Ranks ranks = tickets.calculateRanks(winningTicket);
        Double rateOfRank = ranks.calculateRateOfReturn(price);
        Result result = new Result(ranks, rateOfRank);

        outputView.printResult(result);
    }
}
