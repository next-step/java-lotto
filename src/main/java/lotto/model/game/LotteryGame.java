package lotto.model.game;

import lotto.model.domain.*;
import lotto.model.result.LotteryGameResultDto;
import lotto.model.ticket.LotteryTicket;
import lotto.model.ticket.LotteryTickets;
import lotto.view.InputView;

public class LotteryGame {

    private final LotteryTickets tickets;
    private final LotteryGameResultDto result;

    public LotteryGame(PurchaseInfo purchaseInfo) {
        this.tickets = new LotteryTickets(purchaseInfo.getLotteryCount());
        this.result = new LotteryGameResultDto(purchaseInfo.getAmount());
    }

    public LotteryTickets getLotteryTickets() {
        return this.tickets;
    }

    public LotteryGameResultDto play() {
        LotteryTicket winningTicket = InputView.getWinningTicket();
        Lotto bonus = InputView.getBonusLotto();
        checkBonusDuplicate(winningTicket, bonus);
        for(LotteryTicket ticket : tickets.getTickets()) {
            Rank rank = getRank(winningTicket, ticket, bonus);
            result.plusResultCount(rank);
        }
        return result;
    }

    private void checkBonusDuplicate(LotteryTicket winningTicket, Lotto bonus) {
        if(winningTicket.match(bonus)) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private Rank getRank(LotteryTicket winningTicket, LotteryTicket ticket, Lotto bonus) {
        int matchCount = winningTicket.getMatchCount(ticket);
        return Rank.valueOf(matchCount, ticket.match(bonus));
    }
}