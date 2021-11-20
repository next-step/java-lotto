package lotto.model.game;

import java.util.List;

import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.Winning;
import lotto.model.ticket.LotteryTicket;
import lotto.model.ticket.LotteryTickets;
import lotto.model.domain.Lotto;
import lotto.view.InputView;

public class LotteryGame {

    private final LotteryTickets tickets;
    private final LotteryGameResult result;
    private final static int MIN_PURCHASE_COUNT = 1;

    public LotteryGame(PurchaseInfo purchaseInfo) {
        checkValidation(purchaseInfo.getLotteryCount());
        this.tickets = new LotteryTickets(purchaseInfo.getLotteryCount());
        this.result = new LotteryGameResult(purchaseInfo.getAmount());
    }

    private void checkValidation(int lotteryCount) {
        if(lotteryCount < MIN_PURCHASE_COUNT) {
            throw new IllegalArgumentException("로또를 구매하지 않았습니다.");
        }
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

    private int compareTicket(LotteryTicket winningTicket, LotteryTicket ticket) {
        int count = 0;
        for(Lotto number : ticket.getNumbers()){
            if(winningTicket.match(number)) count++;
        }
        return count;
    }
}