package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final List<Lotto> lottos;
    private final Lotto winningLotto;
    private final Price purchasePrice;
    private final Map<Rank, Integer> rankRecord;

    public LottoStatistics(List<Lotto> lottos, Lotto winningLotto, Price purchasePrice) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.purchasePrice = purchasePrice;
        this.rankRecord = new HashMap<>();
    }

    public Price findWinningPrice() {
        return LottoWinningsCalculator.calculateWinnings(lottos, winningLotto);
    }

    public double calculateEfficiency() {
        return findWinningPrice().divideWithDecimalPoint(purchasePrice);
    }

    public void analyzeRank() {
        initializeRankRecord();
        lottos.stream()
                .map(lotto -> winningLotto.matchCount(lotto))
                .map(Rank::of)
                .forEach(rank -> increaseRecord(rank));
    }

    private void initializeRankRecord() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankRecord.put(rank, 0));
    }

    private void increaseRecord(Rank rank) {
        rankRecord.computeIfPresent(rank, (k, v) -> v+1);
    }

    public int matchRank(Rank rank) {
        return rankRecord.getOrDefault(rank, 0);
    }
}
