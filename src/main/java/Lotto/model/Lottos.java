package Lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private static final int WINNING_LOTTO_STANDARD = 3;
    private static final int DEFAULT_VALUE = 0;
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> summaryLottoResult(Lotto luckyNumber) {
        Map<Rank, Integer> countingRank = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchNumbers(luckyNumber);
            countingRank = this.putCountingRank(countingRank, matchCount);
        }
        return countingRank;
    }

    private Map<Rank, Integer> putCountingRank(Map<Rank, Integer> countingRank, int matchCount) {
        if (matchCount >= WINNING_LOTTO_STANDARD) {
            Rank rank = Rank.getRank(matchCount);
            countingRank.put(rank, countingRank.getOrDefault(rank, DEFAULT_VALUE) + 1);
        }
        return countingRank;
    }
}
