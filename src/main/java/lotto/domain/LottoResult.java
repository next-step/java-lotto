package lotto.domain;

import lotto.utils.Rank;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.ToIntFunction;

import static lotto.utils.Constants.*;

public class LottoResult {
    private final Map<Rank, Integer> ranks = new EnumMap<>(Rank.class);

    public LottoResult() {
        Arrays.stream(Rank.values())
                .forEach(rank -> {
                    ranks.put(rank, NUMBER_ZERO);
                });
    }

    public void calculateResultWin(List<LottoGame> lottoGames) {
        lottoGames.forEach(lottoGame -> {
            Rank rank = Rank.find(lottoGame.getMatchedCount().intValue(), lottoGame.getMatchBonus());
            add(rank);
        });
    }

    private LottoResult add(Rank rank) {
        ranks.merge(rank, NUMBER_ONE, (first, second) -> first + second);
        return this;
    }

    public Double calculateYield(LottoGameCount lottoGameCount) {
        return calculateTotalWinningAmount().doubleValue() / (lottoGameCount.getLottoGameCount().doubleValue() * NUMBER_THOUSAND);
    }

    private Integer calculateTotalWinningAmount() {
        return ranks.entrySet()
                .stream()
                .mapToInt(calculateEachWinningAmount())
                .sum();
    }

    private ToIntFunction<Entry<Rank, Integer>> calculateEachWinningAmount() {
        return entry -> {
            Rank rank = entry.getKey();
            Integer matchedCount = entry.getValue();
            return rank.getWinningMoney() * matchedCount;
        };
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
