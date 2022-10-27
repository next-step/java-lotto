package lotto;

import lotto.domain.*;
import lotto.strategy.AutoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryGame {
    private static final Price lotteryTicketPrice = new Price(1000);

    private LotteryTickets tickets;
    private Result result;

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Price price = new Price(inputView.enterPurchasePrice());
        buyTickets(price);
        outputView.printBuyingTickets(tickets);

        LotteryTicket winningTicket = LotteryTicket.of(inputView.enterWinningNumbers());
        calculateRank(winningTicket);
        outputView.printResult(result);
    }

    private void buyTickets(Price price) {
        Amount amount = price.calculateAmount(lotteryTicketPrice);
        tickets = amount.createTickets(new AutoGenerateStrategy());
    }

    private void calculateRank(LotteryTicket winningTicket) {
        Ranks ranks = tickets.calculateRanks(winningTicket);
        Double rateOfRank = ranks.calculateRateOfReturn(lotteryTicketPrice);
        result = new Result(ranks, rateOfRank);
    }

}
