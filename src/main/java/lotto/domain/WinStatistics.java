package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class WinStatistics {
    private final Map<Rank, Integer> winStatistics;

    private WinStatistics(WinnerNumbers winnerNumbers, LottoTickets lottoTickets) {
        winStatistics = Collections.unmodifiableMap(
            lottoTickets.calculateStatistics(winnerNumbers)
        );
    }

    public static WinStatistics from(WinnerNumbers winnerNumbers, LottoTickets lottoTickets) {
        return new WinStatistics(winnerNumbers, lottoTickets);
    }

    public int countByRank(Rank rank) {
        return winStatistics.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> result() {
        return winStatistics;
    }
}
