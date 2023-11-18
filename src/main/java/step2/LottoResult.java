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

    public int calculateTotalPrizeMoney() {
        return this.lottoRanks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }
}
