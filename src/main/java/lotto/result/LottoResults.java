package lotto.result;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoResults {
    public static final long NONE = 0L;
    private final Map<Rank, Long> values;
    private final float totalPrize;
    private final float profit;

    private LottoResults(Map<Rank, Long> lottoResults, int purchaseAmount) {
        this.values = lottoResults;
        this.totalPrize = totalPrize(lottoResults);
        this.profit = totalPrize / purchaseAmount;
    }

    public static LottoResults from(Map<Rank, Long> lottoResults, int purchaseAmount) {
        return new LottoResults(lottoResults, purchaseAmount);
    }

    public Long matchedLottoNumbersCount(Rank rank) {
        return Optional.ofNullable(values.get(rank)).orElse(NONE);
    }

    public float profit() {
        return this.profit;
    }

    private float totalPrize(Map<Rank, Long> lottoResults) {
        float prize = 0f;

        for (Map.Entry<Rank, Long> entry : lottoResults.entrySet()) {
            Rank matchedNumbersCount = entry.getKey();
            Long quantity = entry.getValue();

            prize += matchedNumbersCount.totalPrize(quantity);
        }

        return prize;
    }

    public Map<Rank, Long> values() {
        return values;
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
