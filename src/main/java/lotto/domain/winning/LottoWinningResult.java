package lotto.domain.winning;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinningResult {
    private Map<LottoWinningAmount, Long> winningResultMap;

    private LottoWinningResult(LottoTickets lottoTickets, LottoTicket winningTicket) {
        this.winningResultMap = createWinningResult(lottoTickets, winningTicket);
    }

    public static LottoWinningResult of(LottoTickets lottoTickets, LottoTicket winningTicket) {
        return new LottoWinningResult(lottoTickets, winningTicket);
    }

    private Map<LottoWinningAmount, Long> createWinningResult(LottoTickets lottoTickets, LottoTicket winningTicket) {
        return lottoTickets.findAll().stream()
                .map(lottoTicket -> {
                    return LottoWinningAmount.find(getMatchCount(lottoTicket, winningTicket),
                            lottoTicket.existNumber(winningTicket.getBonusNumber()));
                })
                .collect(Collectors.toMap(o -> o, o -> 1L, Long::sum));
    }

    private long getMatchCount(LottoTicket lottoTicket, LottoTicket winningTicket) {
        return lottoTicket.findAll().stream()
                .filter(winningTicket::existNumber)
                .count();
    }

    public long getWinningCount(LottoWinningAmount lottoWinningAmount) {
        return winningResultMap.getOrDefault(lottoWinningAmount, 0L);
    }

    public long getTotalWinningAmount() {
        return winningResultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }
}
