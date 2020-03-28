package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoGameResults {
    private static final int LOTTO_WIN_MIN = 3;
    private static final int LOTTO_WIN_MAX = 6;

    private final int totalGameCount;
    private final List<Long> winningGames;

    LottoGameResults(int totalGameCount, List<Long> winningGames) {
        this.totalGameCount = totalGameCount;
        this.winningGames = winningGames;
    }

    public List<Long> getWinningGames() {
        return new ArrayList<>(winningGames);
    }

    public double getProfitRate() {
        return getWinningPrizeSum() / (double) (totalGameCount * DEFAULT_GAME_PRICE);
    }

    public long getMatchCount(int index) {
        return winningGames.stream()
                .filter(matchCount -> isMatch(matchCount, index))
                .count();
    }

    double getWinningPrizeSum() {
        double winningPrizeSum = 0;
        for (int i = LOTTO_WIN_MIN; i <= LOTTO_WIN_MAX; i++) {
            long count = getMatchCount(i);
            winningPrizeSum += (count * LottoWinningLevel.of(i).getWinningPrize());
        }
        return winningPrizeSum;
    }

    private boolean isMatch(Long matchCount, int checkPoint) {
        return matchCount == checkPoint;
    }
}
