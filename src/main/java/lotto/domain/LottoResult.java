package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Game winner;
    private final Games games;

    public LottoResult(Game winner, Games games) {
        this.winner = winner;
        this.games = games;
    }

    public Map<Rank, Integer> countPerRank() {
        List<Rank> rankForGames = games.checkResult(winner);

        return Arrays.stream(Rank.values())
                .collect(Collectors.toUnmodifiableMap(
                        rank -> rank,
                        rank -> Collections.frequency(rankForGames, rank)));
    }

    private long calculatePrize() {
        return countPerRank().entrySet()
                .stream()
                .map(entry -> {
                    Rank rank = entry.getKey();
                    Integer count = entry.getValue();
                    return (long) rank.wins() * count;
                })
                .reduce(0L, Long::sum);
    }

    public double calculateEarningRate() {
        double rate = (double) calculatePrize() / games.count() / Game.PRICE;

        int decimalPlaces = 2;
        double decimalPlacesCorrectionValue = Math.pow(10, decimalPlaces);

        return Math.round(rate * decimalPlacesCorrectionValue) / decimalPlacesCorrectionValue;
    }
}
