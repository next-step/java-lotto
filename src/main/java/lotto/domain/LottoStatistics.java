package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final int LOTTO_MIN_MATCH_COUNT = 3;

    public List<LottoWinResult> statistics(Map<Long, Long> lottoResult) {
        List<LottoWinResult> lottoResults = new ArrayList<>();
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() >= LOTTO_MIN_MATCH_COUNT)
                .forEach(entry -> lottoResults.add(new LottoWinResult(entry.getKey(), entry.getValue())));
        return lottoResults;
    }

    public LottoWinPercentage rate(int price, List<LottoWinResult> lottoWinResults) {
        int lottoSum = lottoSum(lottoWinResults);
        double rate = Math.floor((double) lottoSum / price * 100) / 100.0;
        return new LottoWinPercentage(rate, isLowerStandard(rate));
    }

    private int lottoSum(List<LottoWinResult> lottoWinResults) {
        int sum = 0;
        for (LottoWinResult lottoWinResult : lottoWinResults) {
            sum += lottoWinResult.income();
        }
        return sum;
    }

    private boolean isLowerStandard(double rate) {
        return rate < 1.0;
    }

}
