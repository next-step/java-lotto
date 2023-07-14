package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public final class LottoResult {
    public static final int MIN_MATCH_COUNT = 3;
    public static final int DEFAULT_VALUE = 0;
    public static final int ADD_COUNT_VALUE = 1;
    private final Map<LottoMatch, Integer> resultMap = new EnumMap<>(LottoMatch.class);

    public LottoResult(Lottos lottos, WinningNumber winningNumber) {
        recordResult(winningNumber, lottos);
    }

    private void recordResult(final WinningNumber winningNumber, final Lottos lottos) {
        setResultMap();
        for (Lotto lotto : lottos.getLottos()) {
            filter(lotto, winningNumber);
        }
    }

    private void setResultMap() {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            resultMap.put(lottoMatch, 0);
        }
    }

    private void filter(final Lotto lotto, final WinningNumber winningNumber) {
        int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
        if (matchCount >= MIN_MATCH_COUNT) {
            boolean isBonus = lotto.hasLottoNumber(winningNumber.getBonusBall());
            recordEach(matchCount, isBonus);
        }
    }

    private void recordEach(final int matchCount, final boolean isBonus) {
        if (LottoMatch.contains(matchCount, isBonus)) {
            LottoMatch lottoMatch = LottoMatch.find(matchCount, isBonus);
            resultMap.put(
                    lottoMatch,
                    resultMap.getOrDefault(lottoMatch, DEFAULT_VALUE) + ADD_COUNT_VALUE
            );
        }
    }

    public float getProfit() {
        float profit = 0;
        for (LottoMatch lottoMatch : resultMap.keySet()) {
            profit += resultMap.get(lottoMatch) * lottoMatch.getPrize();
        }
        return profit;
    }

    public Map<LottoMatch, Integer> getResult() {
        return Collections.unmodifiableMap(resultMap);
    }
}
