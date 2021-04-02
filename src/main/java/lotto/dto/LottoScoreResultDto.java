package lotto.dto;

import java.util.List;

public class LottoScoreResultDto {
    private final List<LottoScoreDto> lottoScoreDtoList;

    public LottoScoreResultDto(List<LottoScoreDto> lottoScoreDtoList) {
        this.lottoScoreDtoList = lottoScoreDtoList;
    }

    public List<LottoScoreDto> getLottoScoreDtoList() {
        return lottoScoreDtoList;
    }
}
