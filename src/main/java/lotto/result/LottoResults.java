package lotto.result;

import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private final Map<MatchedNumbers, Long> values;
    private final float prize;

    public LottoResults(Map<MatchedNumbers, Long> lottoResults) {
        this.values = lottoResults;
        this.prize = totalPrize(lottoResults);
    }

    public void add(MatchedNumbers matchedNumbers, long lottosCount) {
        values.put(matchedNumbers, lottosCount);
    }

    public Map<MatchedNumbers, Long> values() {
        return values;
    }

    public float prize() {
        return prize;
    }

    private float totalPrize(Map<MatchedNumbers, Long> lottoResults) {
        float prize = 0f;

        for (MatchedNumbers matchedNumbers : lottoResults.keySet()) {
            prize += matchedNumbers.prize(lottoResults.get(matchedNumbers));
        }

        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Float.compare(that.prize, prize) == 0 && Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, prize);
    }
}
