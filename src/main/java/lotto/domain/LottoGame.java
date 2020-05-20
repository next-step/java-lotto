package lotto.domain;

import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.prize.Prize;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.WinningLottoTicket;

import java.util.List;

public class LottoGame {

    private final List<LottoTicket> tickets;

    private LottoGame(final List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoGame of(final List<LottoTicket> tickets) {
        return new LottoGame(tickets);
    }

    public LottoPrizeResult play(final WinningLottoTicket winningLottoTicket) {
        LottoPrizeResult result = LottoPrizeResult.init();

        this.tickets.forEach(ticket ->
            result.updateMatchedPrize(Prize.of(ticket.matchedCount(winningLottoTicket)))
        );

        return result;
    }
}
