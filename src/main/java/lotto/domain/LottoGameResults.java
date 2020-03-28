package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoGameResults {
    private static final int LOTTO_WIN_MIN = 3;
    private static final int LOTTO_WIN_MAX = 6;

    private final List<LottoRank> winningGames;

    LottoGameResults(List<LottoRank> winningGames) {
        this.winningGames = winningGames;
    }

    public List<LottoRank> getWinningGames() {
        return new ArrayList<>(winningGames);
    }

    public double getProfitRate() {
        return getWinningPrizeSum() / (double) (winningGames.size() * DEFAULT_GAME_PRICE);
    }

    public long getMatchCount(int matchCount) {
        return winningGames.stream()
                .filter(lottoRank -> isMatch(lottoRank.getMatchCount(), matchCount))
                .count();
    }

    double getWinningPrizeSum() {
        double winningPrizeSum = 0;
        for (int i = LOTTO_WIN_MIN; i <= LOTTO_WIN_MAX; i++) {
            long count = getMatchCount(i);
            winningPrizeSum += (count * LottoRank.of(i).getWinningPrize());
        }
        return winningPrizeSum;
    }

    private boolean isMatch(int matchCount, int checkPoint) {
        return matchCount == checkPoint;
    }

}
