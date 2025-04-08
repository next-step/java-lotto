package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
    private double profitRate;

    public static final int PROFIT_STANDARD = 1;

    public LottoStatistics(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            Rank rank = lotto.getRank();
            statistics.put(rank, statistics.getOrDefault(rank,0) + 1);
        }

        this.makeProfitRate(lottoList.size());
    }


    private void makeProfitRate(int totalLottoCount) {
        AtomicInteger totalPrize = new AtomicInteger();

        statistics.forEach((rank, count) -> {
            totalPrize.addAndGet(rank.getWinningMoney() * count);
        });

        int totalSpent = totalLottoCount * Lotto.PRICE_PER_ONE;
        this.profitRate = (double) totalPrize.get() / totalSpent;
    }

    public String getProfitRate() {
        double truncatedRate = Math.floor(this.profitRate * 100) / 100.0;
        return String.format("%.2f", truncatedRate);
    }

    public boolean isProfit() {
        return this.profitRate > PROFIT_STANDARD;
    }

    public int getCountByRank(Rank rank) {
        return statistics.getOrDefault(rank,0);
    }
}
