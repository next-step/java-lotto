package lotto.dto.result;

import lotto.constant.MatchResult;
import lotto.domain.LottoBuyer;

import java.util.ArrayList;
import java.util.List;

public class WinningStats {

    private double profitRate;
    private List<MatchStats> matchStatsList;

    private WinningStats(double profitRate, List<MatchStats> matchStatsList) {
        this.profitRate = profitRate;
        this.matchStatsList = matchStatsList;
    }

    public static WinningStats from(LottoBuyer lottoBuyer) {
        return new WinningStats(lottoBuyer.calculateProfitRate(), findMatchStatsList(lottoBuyer));
    }

    private static List<MatchStats> findMatchStatsList(LottoBuyer lottoBuyer) {
        List<MatchStats> matchStats = new ArrayList<>();
        for (MatchResult matchResult : MatchResult.values()) {
            int count = lottoBuyer.lottos().countMatchResult(matchResult);
            matchStats.add(new MatchStats(count, matchResult));
        }
        return matchStats;
    }

    public double profitRate() {
        return profitRate;
    }

    public List<MatchStats> matchStatsList() {
        return matchStatsList;
    }
}
