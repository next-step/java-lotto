package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private Rank rank;
    private int matchCount;

    private LottoResult(Rank rank, int matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public static List<LottoResult> matchResult(List<Rank> matchRanks) {
        return Rank.availableRanks().stream()
                .map(rank -> LottoResult.of(rank, matchRanks))
                .collect(Collectors.toList());
    }

    private static LottoResult of(Rank rank, List<Rank> lottoRanks) {
        return new LottoResult(rank, rank.countSameMatch(lottoRanks));
    }

    public boolean isSecond() {
        return rank.isSecond();
    }

    public int getMatchCount() {
        return this.rank.getMatchCount();
    }

    public int getPrize() {
        return this.rank.getPrize();
    }

    public int countWinningLotto() {
        return this.matchCount;
    }
}
