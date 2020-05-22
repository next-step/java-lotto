package lotto.domain;

import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.prize.Prize;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;

import java.util.Map;

public class LottoGame {

    private final LottoTickets tickets;

    private LottoGame(final LottoTickets tickets) {
        this.tickets = tickets;
    }

    public static LottoGame of(final LottoTickets tickets) {
        return new LottoGame(tickets);
    }

    public LottoPrizeResult play(final WinningLottoTicket winningLottoTicket) {
        Map<Prize, Long> prizes = tickets.matchPrizes(winningLottoTicket);
        return LottoPrizeResult.init(prizes);
    }
}
