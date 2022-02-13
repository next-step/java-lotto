package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class MatchResult {

    private final Map<LottoResult, Integer> matchResult;

    public MatchResult(Map<LottoResult, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public static MatchResult init() {
        final Map<LottoResult, Integer> initiateMatchResult = new EnumMap<>(LottoResult.class);
        for (LottoResult lottoResult : LottoResult.values()) {
            initiateMatchResult.put(lottoResult, 0);
        }
        return new MatchResult(initiateMatchResult);
    }

    public MatchResult combine(int matchCount, boolean isBonusNumber) {
        final LottoResult lottoResult = LottoResult.findLottoResult(matchCount, isBonusNumber);
        return combine(lottoResult);
    }

    public MatchResult combine(LottoResult lottoResult) {
        final Map<LottoResult, Integer> newMatchResult = new EnumMap<>(matchResult);
        newMatchResult.put(lottoResult, newMatchResult.getOrDefault(lottoResult, 0) + 1);
        return new MatchResult(newMatchResult);
    }

    public Integer getCount(LottoResult lottoResult) {
        return matchResult.get(lottoResult);
    }

    public Set<LottoResult> getLottoResultSet() {
        return matchResult.keySet();
    }
}
