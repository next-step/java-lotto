package lotto.domain;

import lotto.constant.Rank;
import lotto.dto.LottoGameResultDto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameResult {

    private static final double TWO_DECIMAL_PLACES = 100.0;
    private final Map<Integer, List<Rank>> value;

    public LottoGameResult(List<Rank> value) {
        this.value = value.stream()
                .collect(Collectors.groupingBy(Rank::getMatchingNumberCount));
    }

    public LottoGameResult getResult(List<Rank> ranks) {

        Map<Rank, Integer> result = initEnumMap();

        ranks.forEach(rank -> {
            int rankCount = rank.getMatchingNumberCount();
            result.put(rank, rankCount + 1);
        });

        return new LottoGameResultDto(result);
    }

    private Map<Rank, Integer> initEnumMap() {

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);

        return result;
    }

    public double getRateOfReturn(PurchaseAmount purchaseAmount) {
        double rate = value.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum()
                / purchaseAmount.getAmount();

        return Math.floor(rate * TWO_DECIMAL_PLACES) / TWO_DECIMAL_PLACES;
    }

    public Map<Rank, Integer> getValue() {
        return value;
    }
}
