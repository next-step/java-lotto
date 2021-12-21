package lotto.result;

import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private final Map<MatchedNumbersCount, Long> values;
    private final float totalPrize;
    private float profit;

    private LottoResults(Map<MatchedNumbersCount, Long> lottoResults, int purchaseAmount) {
        this.values = lottoResults;
        this.totalPrize = totalPrize(lottoResults);
        this.profit = totalPrize / purchaseAmount;
    }

    public static LottoResults from(Map<MatchedNumbersCount, Long> lottoResults, int purchaseAmount) {
        return new LottoResults(lottoResults, purchaseAmount);
    }

    public void add(MatchedNumbersCount matchedNumbersCount, long lottosCount) {
        values.put(matchedNumbersCount, lottosCount);
    }

    public Map<MatchedNumbersCount, Long> values() {
        return values;
    }

    public float profit() {
        return this.profit;
    }

    public Long matchedNumbersCount(MatchedNumbersCount matchedNumbersCount) {
        return values.get(matchedNumbersCount);
    }

    private float totalPrize(Map<MatchedNumbersCount, Long> lottoResults) {
        float prize = 0f;

        for (Map.Entry<MatchedNumbersCount, Long> entry : lottoResults.entrySet()) {
            MatchedNumbersCount matchedNumbersCount = entry.getKey();
            Long quantity = entry.getValue();

            prize += matchedNumbersCount.prize(quantity);
        }

        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResults that = (LottoResults) o;
        return Float.compare(that.totalPrize, totalPrize) == 0 && Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, totalPrize);
    }
}
