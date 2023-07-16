package lotto.response;

import lotto.domain.Count;
import lotto.domain.LottoRank;

public class LottoRankResponse {

    private final long matchCount;
    private final boolean bonusMatch;
    private final long price;
    private final long lottoCount;

    public LottoRankResponse(LottoRank lottoRank, Count lottoCount) {
        this.matchCount = lottoRank.getMatchCount();
        this.bonusMatch = lottoRank == LottoRank.SECOND;
        this.price = lottoRank.getPrice().getValue();
        this.lottoCount = lottoCount.getValue();
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public long getPrice() {
        return price;
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
