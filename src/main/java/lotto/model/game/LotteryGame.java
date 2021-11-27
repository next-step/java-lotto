package lotto.model.game;

import lotto.model.domain.*;
import lotto.model.result.LotteryGameResultDto;
import lotto.model.ticket.LotteryTicket;
import lotto.model.ticket.LotteryTickets;
import lotto.view.InputView;

public class LotteryGame {

    private final LotteryTickets tickets;
    private final LotteryGameResultDto result;

    public LotteryGame(LotteryTickets lotteryTickets, LotteryGameResultDto result) {
        this.tickets = lotteryTickets;
        this.result = result;
    }

    public LotteryGameResultDto play() {
        LotteryTicket winningTicket = InputView.getTicket("지난 주 당첨 번호를 입력해 주세요.");
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