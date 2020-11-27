package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameResult {

    private static final int FIFTH_MATCHING_COUNT = 2;
    private static final double TWO_DECIMAL_PLACES = 100.0;
    private final List<Rank> ranks;
    private final PurchaseAmount purchaseAmount;

    public LottoGameResult(List<Rank> ranks, PurchaseAmount purchaseAmount) {
        this.ranks = ranks;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Rank, Integer> getRanks() {
        Map<Integer, List<Rank>> collect = ranks.stream()
                .filter(rank -> rank.getMatchingNumberCount() > FIFTH_MATCHING_COUNT)
                .collect(Collectors.groupingBy(Rank::getMatchingNumberCount));
        Map<Rank, Integer> result = init();
        collect.forEach((key, value) -> result.put(Rank.value(key), result.get(Rank.value(key)) + 1));

        return result;
    }

    private Map<Rank, Integer> init() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);

        return result;
    }

    public double getRateOfReturn() {
        double rate = ranks.stream()
                .mapToDouble(Rank::getPrizeMoney)
                .sum()
                / purchaseAmount.getAmount();

        return Math.floor(rate * TWO_DECIMAL_PLACES) / TWO_DECIMAL_PLACES;
    }

}
