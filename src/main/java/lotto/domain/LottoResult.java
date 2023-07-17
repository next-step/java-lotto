package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public final class LottoResult {
    public static final int DEFAULT_VALUE = 0;
    public static final int ADD_COUNT_VALUE = 1;
    private final Map<LottoMatch, Integer> resultMap = new EnumMap<>(LottoMatch.class);

    public LottoResult(final Lottos lottos, final WinningNumber winningNumber) {
        recordResult(winningNumber, lottos);
    }

    private void recordResult(final WinningNumber winningNumber, final Lottos lottos) {
        setResultMap();
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
            boolean isBonus = lotto.hasLottoNumber(winningNumber.getBonusBall());
            recordEach(matchCount, isBonus);
        }
    }

    private void setResultMap() {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            resultMap.put(lottoMatch, 0);
        }
    }

    private void recordEach(final int matchCount, final boolean isBonus) {
        if (LottoMatch.exists(matchCount, isBonus)) {
            LottoMatch lottoMatch = LottoMatch.find(matchCount, isBonus);
            resultMap.put(
                    lottoMatch,
                    resultMap.getOrDefault(lottoMatch, DEFAULT_VALUE) + ADD_COUNT_VALUE
            );
        }
    }

    public int calculateProfit() {
        int profit = 0;
        for (LottoMatch lottoMatch : resultMap.keySet()) {
            profit += resultMap.get(lottoMatch) * lottoMatch.getPrize();
        }
        return profit;
    }

    public Map<LottoMatch, Integer> getResult() {
        return Collections.unmodifiableMap(resultMap);
    }
}
