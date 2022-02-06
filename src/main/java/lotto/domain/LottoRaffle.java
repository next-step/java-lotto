package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoRaffle {

    private final WinningLotto winningLotto;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void compareLotto(Lotto lotto) {
        final int matchCount = calculateMatchCount(lotto);
        boolean isBonusNumber = calculateBonusNumber(lotto, matchCount);
        if(LottoResult.findLottoResult(matchCount, isBonusNumber) != LottoResult.NOMATCH) {
            LottoResult.increaseMatch(matchCount, isBonusNumber);
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

    public List<LottoResult> getResults() {
        return Arrays.asList(
            LottoResult.MATCH3,
            LottoResult.MATCH4,
            LottoResult.MATCH5,
            LottoResult.MATCH_BONUS,
            LottoResult.MATCH6
        );
    }
}
