package lottogame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class LottoStatistics {

    private final Map<LottoMatch, Integer> statistics = initMap();

    public LottoStatistics(final Lottos lottos, final WinningNumber winningNumber) {
        calculateStatistics(lottos, winningNumber);
    }

    private void calculateStatistics(final Lottos lottos, final WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            filter(lotto, winningNumber);
        }
    }

    private void filter(final Lotto lotto, final WinningNumber winningNumber) {
        int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
        if (matchCount >= 3) {
            record(matchCount, lotto, winningNumber);
        }
    }

    private void record(final int matchCount, final Lotto lotto, final WinningNumber winningNumber) {
        if (matchCount == 5) {
            recordFiveMatch(matchCount, lotto, winningNumber);
            return;
        }
        recordEach(matchCount, false);
    }

    private void recordFiveMatch(final int matchCount, final Lotto lotto, final WinningNumber winningNumber) {
        if (lotto.hasLottoNumber(winningNumber.getBonusBall())) {
            recordEach(matchCount, true);
            return;
        }
        recordEach(matchCount, false);
    }

    private void recordEach(final int matchCount, final boolean isBonus) {
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

    public String getProfitRate(final Payment payment) {
        float profit = 0;
        for (LottoMatch lottoMatch : statistics.keySet()) {
            profit += statistics.get(lottoMatch) * lottoMatch.getPrize();
        }
        return String.format("%.2f", profit / payment.getMoney());
    }
}
