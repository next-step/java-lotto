package lotto.dto.view;

import lotto.constants.Winning;

import java.util.Map;

public class LottoResultDTO {

    private Map<Winning, Long> winnings;
    private float profitRate;

    public LottoResultDTO(Map<Winning, Long> winnings, float profitRate) {
        this.winnings = winnings;
        this.profitRate = profitRate;
    }

    public Map<Winning, Long> winnings() {
        return winnings;
    }

    public float profitRate() {
        return profitRate;
    }
}
