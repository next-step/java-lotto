package lotto.view.dto;

import java.util.List;

public class LottoScoringResultDto {
    private final List<LottoWinnerDto> winnerDtoList;
    private final String earningRate;

    public LottoScoringResultDto(List<LottoWinnerDto> winnerDtoList, String earningRate) {
        this.winnerDtoList = winnerDtoList;
        this.earningRate = earningRate;
    }

    public String getEarningRate() {
        return earningRate;
    }

    public List<LottoWinnerDto> getWinnerDtoList() {
        return winnerDtoList;
    }
}
