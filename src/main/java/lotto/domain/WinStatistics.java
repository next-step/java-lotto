package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinStatistics {
    private final Map<Integer, Integer> winStatistics;

    private WinStatistics(LottoBalls winnerNumbers, LottoTickets lottoTickets) {
        winStatistics = new HashMap<>();

        for (LottoBalls e : lottoTickets.toLottoBallsList()) {
            int rank = e.countMatchNumber(winnerNumbers);
            winStatistics.put(rank, winStatistics.getOrDefault(rank, 0) + 1);
        }
    }

    public static WinStatistics from(LottoBalls winnerBalls, LottoTickets lottoTickets) {
        return new WinStatistics(winnerBalls, lottoTickets);
    }

    public int countByRank(Rank rank) {
        return winStatistics.get(rank.getMatchCount());
    }

    public Map<Integer, Integer> result() {
        return winStatistics;
    }
}
