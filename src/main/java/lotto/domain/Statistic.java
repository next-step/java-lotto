package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private final WinLottoNumber winLottoNumber;
    private final List<GameResult> gameResults;

    public Statistic(Lottos lottos, WinLottoNumber winNumber) {
        winLottoNumber = winNumber;
        gameResults = new ArrayList<>();
        calculate(lottos);
    }

    private void calculate(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int match = lotto.matchCount(winLottoNumber.winLotto());
            boolean matchBonus = lotto.matchBonus(winLottoNumber.bonusNumber());
            gameResults.add(new GameResult(match, matchBonus));
        }
    }

    public Map<Rank, Integer> result() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (GameResult gameResult : gameResults) {
            Rank rank = gameResult.result();
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    public double getProfitRate(int paidMoney) {
        return (double) getTotalPrize() / paidMoney;
    }

    public long getTotalPrize() {
        return gameResults.stream()
            .map(gameResult -> gameResult.result().getWinningMoney())
            .mapToLong(Long::valueOf)
            .sum();
    }

}
