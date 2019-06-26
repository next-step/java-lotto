package lotto.domain.winning;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.stream.Collectors;

public class LottoWinningChecker {
    private final LottoTickets lottoTickets;
    private final LottoTicket winningTicket;

    private LottoWinningChecker(LottoTickets lottoTickets, LottoTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public static LottoWinningChecker of(LottoTickets lottoTickets, LottoTicket winningTicket) {
        return new LottoWinningChecker(lottoTickets, winningTicket);
    }

    private long getMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.findAll().stream()
                .filter(winningTicket::existNumber)
                .count();
    }

    public LottoWinningResult getWinnigResult() {
        return LottoWinningResult.of(lottoTickets.findAll().stream()
                .map(this::getMatchCount)
                .map(LottoWinningAmount::find)
                .collect(Collectors.toMap(o -> o, o -> 1L, Long::sum)));
    }
}
