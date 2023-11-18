package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public LottoResult(LottoRank... lottoRanks) {
        List<LottoRank> ranks = new ArrayList<>();
        for (LottoRank lottoRank : lottoRanks) {
            ranks.add(lottoRank);
        }
        this.lottoRanks = ranks;
    }

    public double calculateProfitRate(int money) {
        return (calculateTotalPrizeMoney() * 100 / (money * 1000));
    }

    private long calculateTotalPrizeMoney() {
        return this.lottoRanks.stream()
                .mapToLong(LottoRank::getPrizeMoney)
                .sum();
    }
}
