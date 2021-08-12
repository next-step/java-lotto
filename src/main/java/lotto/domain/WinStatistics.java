package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinStatistics {
    private final Map<Rank, Integer> winStatistics;

    private WinStatistics(LottoBalls winnerNumbers, LottoBall bonusBall, LottoTickets lottoTickets) {
        winStatistics = new HashMap<>();

        for (LottoBalls lottoBalls : lottoTickets.toLottoBallsList()) {
            Rank rank = Rank.valueOf(lottoBalls.countMatchNumber(winnerNumbers), lottoBalls.contains(bonusBall.number()));
            winStatistics.put(rank, winStatistics.getOrDefault(rank, 0) + 1);
        }
    }

    public static WinStatistics from(LottoBalls winnerBalls, LottoBall bonusBall, LottoTickets lottoTickets) {
        return new WinStatistics(winnerBalls, bonusBall, lottoTickets);
    }

    public int countByRank(Rank rank) {
        return winStatistics.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> result() {
        return winStatistics;
    }
}
