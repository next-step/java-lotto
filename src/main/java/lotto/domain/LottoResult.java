package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class LottoResult {
    public static final int MIN_MATCH_COUNT = 3;
    private final Map<LottoMatch, Integer> resultMap = new HashMap<>();

    public LottoResult() {
        init();
    }

    private void init() {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            resultMap.put(lottoMatch, 0);
        }
    }

    public void recordResult(final Lottos lottos, final WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            filter(lotto, winningNumber);
        }
    }

    public float getProfit() {
        float profit = 0;
        for (LottoMatch lottoMatch : resultMap.keySet()) {
            profit += resultMap.get(lottoMatch) * lottoMatch.getPrize();
        }
        return profit;
    }

    private void filter(final Lotto lotto, final WinningNumber winningNumber) {
        int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
        if (matchCount >= MIN_MATCH_COUNT) {
            boolean b = lotto.hasLottoNumber(winningNumber.getBonusBall());
            recordEach(matchCount, b);
        }
    }

    private void recordEach(final int matchCount, final boolean isBonus) {
        LottoMatchKey lottoMatchKey = new LottoMatchKey(isBonus, matchCount);
        if (LottoMatch.containsKey(lottoMatchKey)) {
            resultMap.put(
                    LottoMatch.find(lottoMatchKey),
                    resultMap.getOrDefault(LottoMatch.find(lottoMatchKey), 0) + 1
            );
        }
    }

    public Map<LottoMatch, Integer> getResult() {
        return Collections.unmodifiableMap(resultMap);
    }
}
