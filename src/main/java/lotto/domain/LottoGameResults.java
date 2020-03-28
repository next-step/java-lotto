package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGameResults {
    private final int totalGameCount;
    private final List<Long> winningGames;

    public LottoGameResults(int totalGameCount, List<Long> winningGames) {
        this.totalGameCount = totalGameCount;
        this.winningGames = winningGames;
    }

    public int getTotalGameCount() {
        return totalGameCount;
    }

    public List<Long> getWinningGames() {
        return new ArrayList<>(winningGames);
    }
}
