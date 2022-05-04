package step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final Map<LottoRank, Integer> rankCount;

    public GameResult(List<Long> hitCounts) {
        this.rankCount = initRankCount();
        hitCounts.stream()
                .map(LottoRank::toRank)
                .forEach(this::putToRankCount);
    }

    private EnumMap<LottoRank, Integer> initRankCount() {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        result.remove(LottoRank.ETC);
        return result;
    }

    private void putToRankCount(LottoRank lottoRank) {
        this.rankCount.computeIfPresent(lottoRank, (lottoRank1, integer) -> integer + 1);
    }

    public double calculateReturnRate(int purchaseAmount) {
        return getPrizeMoneySum() / (double) purchaseAmount;
    }

    private int getPrizeMoneySum() {
        return rankCount.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCount;
    }
}
