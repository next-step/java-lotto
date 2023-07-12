package lottogame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoMatch, Integer> statistics = initMap();

    public LottoStatistics(Lottos lottos, WinningNumber winningNumber) {
        calculateStatistics(lottos, winningNumber);
    }

    private void calculateStatistics(Lottos lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            filter(lotto, winningNumber);
        }
    }

    private void filter(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
        if (matchCount >= 3) {
            record(matchCount, lotto, winningNumber);
        }
    }

    private void record(int matchCount, Lotto lotto, WinningNumber winningNumber) {
        if (matchCount == 5) {
            recordFiveMatch(matchCount, lotto, winningNumber);
            return;
        }
        recordEach(matchCount, false);
    }

    private void recordFiveMatch(int matchCount, Lotto lotto, WinningNumber winningNumber) {
        if (lotto.hasLottoNumber(winningNumber.getBonusBall())) {
            recordEach(matchCount, true);
            return;
        }
        recordEach(matchCount, false);
    }

    private void recordEach(int matchCount, boolean isBonus) {
        LottoMatchKey lottoMatchKey = new LottoMatchKey(isBonus, matchCount);
        statistics.put(LottoMatch.find(lottoMatchKey),
            statistics.getOrDefault(LottoMatch.find(lottoMatchKey), 0) + 1
        );
    }

    private Map<LottoMatch, Integer> initMap() {
        Map<LottoMatch, Integer> resultMap = new HashMap<>();
        Arrays.stream(LottoMatch.values())
            .forEach(lottoMatch -> resultMap.put(lottoMatch, 0));
        return resultMap;
    }

    public Map<LottoMatch, Integer> getStatistics() {
        return statistics;
    }

    public String getProfitRate(Payment payment) {
        float profit = 0;
        for (LottoMatch lottoMatch : statistics.keySet()) {
            profit += statistics.get(lottoMatch) * lottoMatch.getPrize();
        }
        return String.format("%.2f", profit / payment.getMoney());
    }
}
