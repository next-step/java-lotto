package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final LottoNumbers winner;
    private final Games games;
    private LottoNumber bonusLottoNumber;

    public LottoResult(LottoNumbers winner, LottoNumber bonusLottoNumber, Games games) {
        this.winner = winner;
        this.bonusLottoNumber = bonusLottoNumber;
        this.games = games;
    }

    public Map<Rank, Integer> countPerRank() {
        List<Rank> rankForGames = games.checkResult(winner, bonusLottoNumber);

        return Arrays.stream(Rank.values())
                .collect(Collectors.toUnmodifiableMap(
                        rank -> rank,
                        rank -> Collections.frequency(rankForGames, rank))
                );
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
        double rate = (double) calculatePrize() / games.count() / LottoNumbers.PRICE;

        int decimalPlaces = 2;
        double decimalPlacesCorrectionValue = Math.pow(10, decimalPlaces);

        return Math.round(rate * decimalPlacesCorrectionValue) / decimalPlacesCorrectionValue;
    }
}
