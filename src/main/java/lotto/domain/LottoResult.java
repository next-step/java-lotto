package lotto.domain;

import java.util.List;

public class LottoResult {

    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int findWinningCount(Rank rank) {
        return (int) ranks.stream().filter(finalRank -> finalRank.equals(rank)).count();
    }

    public double findRateOfReturn() {
        return (double) winnings() / getLottoPrice();
    }

    private int getLottoPrice() {
        return ranks.size() * Lotto.LOTTO_PRICE;
    }

    private int winnings() {
        return ranks.stream().mapToInt(Rank::getWinnings).sum();
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}