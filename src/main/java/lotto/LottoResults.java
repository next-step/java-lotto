package lotto;

import java.util.Map;

public class LottoResults {
    private final Map<MatchedNumbers, Long> values;
    private final float prize;

    public LottoResults(Map<MatchedNumbers, Long> lottoResults) {
        this.values = lottoResults;
        this.prize = sumPrize(lottoResults);
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

    private float sumPrize(Map<MatchedNumbers, Long> lottoResults) {
        float prize = 0f;

        for (MatchedNumbers matchedNumbers : lottoResults.keySet()) {
            prize += matchedNumbers.prize(lottoResults.get(matchedNumbers));
        }

        return prize;
    }
}
