package lotto.dto.result;

import lotto.constant.Rank;
import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.List;

public class WinningStats {

    private double profitRate;
    private List<MatchStats> matchStatsList;

    private WinningStats(double profitRate, List<MatchStats> matchStatsList) {
        this.profitRate = profitRate;
        this.matchStatsList = matchStatsList;
    }

    public static WinningStats from(LottoGame lottoGame) {
        return new WinningStats(lottoGame.calculateProfitRate(), findMatchStatsList(lottoGame));
    }

    private static List<MatchStats> findMatchStatsList(LottoGame lottoGame) {
        List<MatchStats> matchStats = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            int count = lottoGame.countMatchResult(rank);
            matchStats.add(new MatchStats(count, rank));
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
