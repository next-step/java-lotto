package lotto.model.game;

import java.util.List;

import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.Winning;
import lotto.model.ticket.LotteryTicket;
import lotto.model.ticket.LotteryTickets;
import lotto.view.InputView;

public class LotteryGame {

    private final static int MIN_PURCHASE_COUNT = 1;
    private final LotteryTickets tickets;
    private final LotteryGameResult result;

    public LotteryGame(PurchaseInfo purchaseInfo) {
        checkValidation(purchaseInfo.getLotteryCount());
        this.tickets = new LotteryTickets(purchaseInfo.getLotteryCount());
        this.result = new LotteryGameResult(purchaseInfo.getAmount());
    }

    public LotteryTickets getLotteryTickets() {
        return this.tickets;
    }

    public List<String> play() {
        LotteryTicket winningTicket = InputView.getWinningTicket();
        for(LotteryTicket ticket : tickets.getTickets()) {
            int match = compareTicket(winningTicket, ticket);
            Winning.win(match);
        }
        return result.get();
    }

    private void checkValidation(int lotteryCount) {
        if(lotteryCount < MIN_PURCHASE_COUNT) {
            throw new IllegalArgumentException("로또를 구매하지 않았습니다.");
        }
    }

    private int compareTicket(LotteryTicket winningTicket, LotteryTicket ticket) {
        return (int) ticket.getNumbers()
                        .stream()
                        .filter(number -> winningTicket.match(number))
                        .count();
    }
}