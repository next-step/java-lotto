package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public LottoResult() {
        this.lottoRanks = new ArrayList<>();
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }

    public float getMargin(int fee) {
        return (float) getTotalReturn() / fee;
    }

    private int getTotalReturn() {
        return lottoRanks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }

    public void add(LottoRank lottoRank) {
        this.lottoRanks.add(lottoRank);
    }

    public int count(LottoRank lottoRank) {
        return (int) lottoRanks.stream()
                .filter(rank -> lottoRank == rank)
                .count();
    }
}
