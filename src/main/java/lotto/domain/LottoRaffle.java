package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

public class LottoRaffle {

    private final WinningLotto winningLotto;
    private final Map<LottoResult, Integer> matchResult;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        matchResult = initiateMatchMap();
    }

    private Map<LottoResult, Integer> initiateMatchMap() {
        final Map<LottoResult, Integer> initiateMatchResult = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            initiateMatchResult.put(lottoResult, 0);
        }
        return new HashMap<>(initiateMatchResult);
    }

    public void compareLotto(Lotto lotto) {
        final int matchCount = calculateMatchCount(lotto);
        boolean isBonusNumber = calculateBonusNumber(lotto);

        final LottoResult lottoResult = LottoResult.findLottoResult(matchCount, isBonusNumber);
        if (lottoResult != LottoResult.NO_MATCH) {
            matchResult.put(lottoResult, matchResult.get(lottoResult) + 1);
        }
    }

    private boolean calculateBonusNumber(Lotto lotto) {
        return lotto.hasNumber(winningLotto.getBonusNumber());
    }

    private Integer calculateMatchCount(Lotto lotto) {
        return Math.toIntExact(
            lotto.getLotto().getNumbersValue().stream().filter(winningLotto::hasNumber).count());
    }

    public Map<LottoResult, Integer> getResults() {
        return matchResult;
    }
}
