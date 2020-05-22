package lotto.domain;

import lotto.domain.price.Price;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.prize.Prize;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;

import java.util.Map;

public class LottoGame {

    private final Price price;
    private final LottoTickets tickets;

    private LottoGame(final Price price, final LottoTickets tickets) {
        this.price = price;
        this.tickets = tickets;
    }

    public static LottoGame of(final Price price, final LottoTickets tickets) {
        return new LottoGame(price, tickets);
    }

    public LottoPrizeResult play(final WinningLottoTicket winningLottoTicket) {
        Map<Prize, Long> prizes = tickets.matchPrizes(winningLottoTicket);
        return LottoPrizeResult.init(this.price, prizes);
    }
}
