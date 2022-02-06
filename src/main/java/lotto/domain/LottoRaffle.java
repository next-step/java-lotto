package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRaffle {

    private final WinningLotto winningLotto;
    private final Map<LottoResult, Integer> matchResult;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        matchResult = initiateMatchMap();
    }

    private Map<LottoResult, Integer> initiateMatchMap() {
        final Map<LottoResult, Integer> matchResult = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            matchResult.put(lottoResult, 0);
        }
        return new HashMap<>(matchResult);
    }

    public void compareLotto(Lotto lotto) {
        final int matchCount = calculateMatchCount(lotto);
        boolean isBonusNumber = calculateBonusNumber(lotto, matchCount);

        final LottoResult lottoResult = LottoResult.findLottoResult(matchCount, isBonusNumber);
        if (lottoResult != LottoResult.NO_MATCH) {
            matchResult.put(lottoResult, matchResult.get(lottoResult) + 1);
        }
    }

    private boolean calculateBonusNumber(Lotto lotto, int matchCount) {
        if (matchCount != 5) {
            return false;
        }
        return lotto.hasNumber(winningLotto.getBonusNumber());
    }

    private Integer calculateMatchCount(Lotto lotto) {
        return lotto.getLotto().stream().reduce(0, (origin, value) -> {
            if (winningLotto.hasNumber(value)) {
                return origin + 1;
            }
            return origin;
        });
    }

    public Map<LottoResult, Integer> getResults() {
        return matchResult;
    }
}
