package lotto.result;

import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private final Map<MatchedNumbersCount, Long> values;
    private final float prize;

    public LottoResults(Map<MatchedNumbersCount, Long> lottoResults) {
        this.values = lottoResults;
        this.prize = totalPrize(lottoResults);
    }

    public void add(MatchedNumbersCount matchedNumbersCount, long lottosCount) {
        values.put(matchedNumbersCount, lottosCount);
    }

    public Map<MatchedNumbersCount, Long> values() {
        return values;
    }

    public float prize() {
        return prize;
    }

    private float totalPrize(Map<MatchedNumbersCount, Long> lottoResults) {
        float prize = 0f;

        for (MatchedNumbersCount matchedNumbersCount : lottoResults.keySet()) {
            prize += matchedNumbersCount.prize(lottoResults.get(matchedNumbersCount));
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
        return Float.compare(that.prize, prize) == 0 && Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, prize);
    }
}
