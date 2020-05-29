package lotto.domain.winning;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Price;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class WinningStatistics {
    private final Price price;
    private final EnumMap<LottoRank, Integer> lottoRank;

    public WinningStatistics(Price price, Map<LottoRank, Long> lottoRank) {
        this.price = price;
        this.lottoRank = new EnumMap(LottoRank.class);
        modifyLottoRank(lottoRank);
    }

    private void modifyLottoRank(Map<LottoRank, Long> lottoRank) {
        EnumSet.allOf(LottoRank.class)
                .forEach(rank -> this.lottoRank.put(rank, Math.toIntExact(lottoRank.getOrDefault(rank, 0L))));
        this.lottoRank.remove(LottoRank.MISS);
    }

    public Map<LottoRank, Integer> getLottoRank() {
        return lottoRank;
    }

    public float calculateProfit() {
        int rankSum = this.lottoRank.keySet()
                .stream()
                .mapToInt(this::calculateRank)
                .sum();

        return price.calculateProfitRate(rankSum);
    }

    private int calculateRank(LottoRank rank) {
        return rank.getWinningMoney() * this.getMatchedTicketCount(rank);
    }

    private int getMatchedTicketCount(LottoRank rank) {
        return this.lottoRank.get(rank);
    }

    public Price getPrice() {
        return price;
    }
}
