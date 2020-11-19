package step3.dto;

import step3.domain.LottoRank;

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
