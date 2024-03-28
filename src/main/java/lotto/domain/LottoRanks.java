package lotto.domain;

import java.util.List;

public class LottoRanks {

    private List<LottoRank> lottoRanks;
    private Fee fee;

    public LottoRanks(List<LottoRank> lottoRanks, Fee fee) {
        this.lottoRanks = lottoRanks;
        this.fee = fee;
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }

    public float getMargin() {
        return (float) getTotalReturn() / fee.getValue();
    }

    private int getTotalReturn() {
        return lottoRanks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }
}
