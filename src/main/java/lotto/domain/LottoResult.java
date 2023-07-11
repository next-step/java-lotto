package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Long> result;

    public LottoResult(final Map<LottoRank, Long> result) {
        this.result = result;
    }

    public Money calculateTotalPrize() {
        Long totalPrize = result.keySet()
            .stream()
            .mapToLong(key -> key.getPrize() * result.get(key))
            .sum();
        return new Money(totalPrize);
    }

    public Map<LottoRank, Long> getResult() {
        return result;
    }

    public Double calculateYield() {
        return this.calculateTotalPrize()
            .calculateYield(
                calculateTotalMoney()
            );
    }

    private Money calculateTotalMoney() {
        long totalQuantity = result.values()
            .stream()
            .mapToLong(Long::longValue)
            .sum();
        return new Money(totalQuantity * LottoManager.LOTTO_PRICE);
    }

}
