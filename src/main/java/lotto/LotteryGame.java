package lotto;

import lotto.domain.*;
import lotto.strategy.AutoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryGame {
    private static final Price lotteryTicketPrice = new Price(1000);
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private LotteryTickets tickets;
    private Result result;

    public void start() {
        Price price = new Price(inputView.enterPurchasePrice());
        Amount amountOfManualTickets = new Amount(inputView.enterAmountOfManualTickets());
        tickets = LotteryTickets.of(inputView.enterManualTickets(amountOfManualTickets));
        buyAutoTickets(price, amountOfManualTickets);
        outputView.printBuyingTickets(tickets, amountOfManualTickets);

        WinningTicket winningTicket = new WinningTicket(inputView.enterWinningNumbers(), inputView.enterBonusBoll());
        calculateRank(winningTicket);
        outputView.printResult(result);
    }

    private void buyAutoTickets(Price price, Amount amountOfManualTicket) {
        Amount amountOfTickets = price.calculateAmount(lotteryTicketPrice);
        Amount amountOfAutoTicket = amountOfTickets.minus(amountOfManualTicket);
        tickets.add(amountOfAutoTicket.createTickets(new AutoGenerateStrategy()));
    }

    private void calculateRank(WinningTicket winningTicket) {
        Ranks ranks = tickets.calculateRanks(winningTicket);
        Double rateOfRank = ranks.calculateRateOfReturn(lotteryTicketPrice);
        result = new Result(ranks, rateOfRank);
    }
}
