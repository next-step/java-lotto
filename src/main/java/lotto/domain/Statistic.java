package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.game.Game;

public class Statistic {

    private final List<Rank> gameResults;
    private int paidMoney;

    public Statistic(Lottos lottos, WinLottoNumber winNumber) {
        gameResults = new ArrayList<>();
        calculate(lottos, winNumber);
        this.paidMoney = lottos.size() * Game.LOTTO_PRICE;
    }

    private void calculate(Lottos lottos, WinLottoNumber winNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            int match = lotto.matchCount(winNumber.winLotto());
            boolean matchBonus = lotto.matchBonus(winNumber.bonusNumber());
            gameResults.add(Rank.valueOf(match, matchBonus));
        }
    }

    public Map<Rank, Integer> result() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Rank rank : gameResults) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    public double getProfitRate() {
        return (double) getTotalPrize() / paidMoney;
    }

    public long getTotalPrize() {
        return gameResults.stream()
            .map(Rank::getWinningMoney)
            .mapToLong(Long::valueOf)
            .sum();
    }

}
