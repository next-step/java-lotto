package lotto.domain.product;

import lotto.domain.Money;
import lotto.domain.PaymentReceipt;

import java.util.HashMap;
import java.util.Map;

public class FinalResult {

    private Map<Integer, Integer> result;

    public FinalResult() {
        this.result = new HashMap<>();
    }

    public void put(Integer number) {
        Integer count = result.getOrDefault(number, 0);
        result.put(number, count + 1);
    }

    public Integer get(Integer number) {
        return result.get(number);
    }

    public double returnRate(PaymentReceipt paid) {
        Money totalPrize = getTotalPrize();
        return paid.getRateBy(totalPrize);
    }

    public Money getTotalPrize() {
        Money totalPrize = new Money(0);
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int matchCount = entry.getKey();
            int count = entry.getValue();

            LottoRank rank = LottoRank.of(matchCount);
            int prizePerWin = rank.getPrize();

            totalPrize = totalPrize.add(new Money(prizePerWin * count));
        }
        return totalPrize;
    }

}
