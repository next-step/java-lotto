package step2.dto;

import step2.domain.LottoRank;

public class LottoResultDto {

    private final LottoRank lottoRank;
    private final int prize ;

    public LottoResultDto(LottoRank lottoRank, int prize) {
        this.lottoRank = lottoRank;
        this.prize = prize;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public int getPrize() {
        return prize;
    }
}
