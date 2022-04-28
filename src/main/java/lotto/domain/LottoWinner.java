package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoWinner {
    private final Map<LottoWinnerType, Integer> winners;

    LottoWinner(Map<LottoWinnerType, Integer> winners) {
        this.winners = winners;
    }

    public Map<LottoWinnerType, Integer> getWinners() {
        return Collections.unmodifiableMap(winners);
    }
}
