package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public Map<Rank, Long> getStatistics() {
        return ranks.stream().collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public long calculateTotalPrize() {
        return ranks.stream().mapToLong(Rank::getPrize).sum();
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (double) calculateTotalPrize() / purchaseAmount;
    }

    public enum Rank {
        FIRST(6, 2_000_000_000), SECOND(5, 1_500_000), THIRD(4, 50_000), FOURTH(3, 5_000), MISS(0,
                0);

        private final int matchCount;
        private final int prize;

        Rank(int matchCount, int prize) {
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public static Rank valueOf(int matchCount) {
            return Arrays.stream(values()).filter(rank -> rank.matchCount == matchCount).findFirst()
                    .orElse(MISS);
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrize() {
            return prize;
        }
    }
}
