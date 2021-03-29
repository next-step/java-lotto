package lotto.view.dto;

import java.util.List;

public class LottoScoringDto {
    private final LottoDto winnerLottoDto;
    private final LottoOrderResultDto lottoOrderResultDto;

    public LottoScoringDto(LottoDto winnerLottoDto, LottoOrderResultDto lottoOrderResultDto) {
        this.winnerLottoDto = winnerLottoDto;
        this.lottoOrderResultDto = lottoOrderResultDto;
    }

    public List<Integer> getLottoWinnerNumber() {
        return winnerLottoDto.getNumbers();
    }

    public List<LottoDto> getLottoOrderedNumber() {
        return lottoOrderResultDto.getOrderedResult();
    }
}
