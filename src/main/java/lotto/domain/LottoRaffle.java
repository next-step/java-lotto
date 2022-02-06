package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoRaffle {

    private final WinningLotto winningLotto;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void compareLotto(Lotto lotto) {
        int count = lotto.getLotto().stream().reduce(0, (origin, value) -> {
            if (winningLotto.hasNumber(value)) {
                return origin + 1;
            }
            return origin;
        });

        boolean isBonusNumber = lotto.getLotto().contains(winningLotto.getBonusNumber());
        if (count != 5) {
            isBonusNumber = false;
        }

        if(LottoResult.findLottoResult(count, isBonusNumber) != LottoResult.NOMATCH) {
            LottoResult.increaseMatch(count, isBonusNumber);
        }
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
