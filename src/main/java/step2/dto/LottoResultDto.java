package step2.dto;

import step2.domain.LottoRank;

public class LottoResultDto {

    private final LottoRank lottoRank;
    private final int prize ;

    public LottoResultDto(LottoRank lottoRank, int prize) {
        this.lottoRank = lottoRank;
        this.prize = prize;
    }

    public int getLottoRankMatchCount() {
        return lottoRank.getMatch();
    }
    public int getLottoRankPrice() {
        return lottoRank.getPrice();
    }
    public int getPrize() {
        return prize;
    }
}
