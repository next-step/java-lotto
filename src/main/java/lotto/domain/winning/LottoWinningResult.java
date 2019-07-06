package lotto.domain.winning;

import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLotto;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinningResult {
    private Map<LottoWinningAmount, Long> winningResultMap;

    private LottoWinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        this.winningResultMap = createWinningResult(lottoTickets, winningLotto);
    }

    public static LottoWinningResult of(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return new LottoWinningResult(lottoTickets, winningLotto);
    }

    private Map<LottoWinningAmount, Long> createWinningResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoTickets.findAll().stream()
                .map(lottoTicket -> {
                    return LottoWinningAmount.find(winningLotto.getMatchCount(lottoTicket),
                            winningLotto.matchBonusNumber(lottoTicket));
                })
                .collect(Collectors.toMap(winningAmount -> winningAmount, winningAmount -> 1L, Long::sum));
    }

    public long getWinningCount(LottoWinningAmount lottoWinningAmount) {
        return winningResultMap.getOrDefault(lottoWinningAmount, 0L);
    }

    public long getTotalWinningAmount() {
        return winningResultMap.entrySet().stream()
                .mapToLong(winningResult -> winningResult.getKey().getWinningAmount() * winningResult.getValue())
                .sum();
    }
}
