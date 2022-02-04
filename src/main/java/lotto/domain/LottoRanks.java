package lotto.domain;

import java.util.List;

public class LottoRanks {

    private final List<LottoRank> lottoRanks;

    public LottoRanks(final List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<LottoRank> get() {
        return this.lottoRanks;
    }
}
