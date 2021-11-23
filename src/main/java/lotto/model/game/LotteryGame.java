package lotto.model.game;

import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.Winning;
import lotto.model.ticket.LotteryTicket;
import lotto.model.ticket.LotteryTickets;
import lotto.view.InputView;

public class LotteryGame {

    private final LotteryTickets tickets;

    public LotteryGame(PurchaseInfo purchaseInfo) {
        this.tickets = new LotteryTickets(purchaseInfo.getLotteryCount());
    }

    public LotteryTickets getLotteryTickets() {
        return this.tickets;
    }

    public void play() {
        LotteryTicket winningTicket = InputView.getWinningTicket();
        for(LotteryTicket ticket : tickets.getTickets()) {
            int match = compareTicket(winningTicket, ticket);
            Winning.win(match);
        }
    }

    private int compareTicket(LotteryTicket winningTicket, LotteryTicket ticket) {
        return (int) ticket.getNumbers()
                        .stream()
                        .filter(winningTicket::match)
                        .count();
    }
}