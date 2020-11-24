package lotto.domain;

import lotto.constant.Rank;

import java.util.Map;

public class LottoGameResult {

    private static final double TWO_DECIMAL_PLACES = 100.0;
    private final Map<Rank, Integer> value;

    public LottoGameResult(Map<Rank, Integer> value) {
        this.value = value;
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
