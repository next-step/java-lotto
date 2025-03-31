package lotto.domain.product;

import lotto.domain.Money;
import lotto.domain.PaymentReceipt;

import java.util.EnumMap;
import java.util.Map;

public class FinalResult {

    private final Map<LottoRank, Integer> result;

    public FinalResult() {
        this.result = new EnumMap<>(LottoRank.class);
    }

    public void put(LottoRank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public double returnRate(PaymentReceipt paid) {
        Money totalPrize = calculateTotalReward();
        return paid.getRateBy(totalPrize);
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public Money calculateTotalReward() {
        return new Money(result.entrySet().stream()
                .mapToInt(e -> e.getKey().getPrize() * e.getValue())
                .sum());
    }

}
