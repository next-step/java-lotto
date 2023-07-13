package lotto.dto;

import lotto.domain.LottoRank;

public class LottoRankDto {

    private final long matchCount;
    private final boolean bonusMatch;
    private final long price;
    private final long lottoCount;

    public LottoRankDto(LottoRank lottoRank, long lottoCount) {
        this.matchCount = lottoRank.getMatchCount();
        this.bonusMatch = lottoRank == LottoRank.SECOND;
        this.price = lottoRank.getPrice();
        this.lottoCount = lottoCount;
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
