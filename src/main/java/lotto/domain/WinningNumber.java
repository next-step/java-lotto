package lotto.domain;

import java.util.Set;

public class WinningNumber {
    private final Lotto winningNumber;

    public WinningNumber(final Set<LottoNumber> winningNumbers) {
        this.winningNumber = new Lotto(winningNumbers);
    }

    public LottoRewards findLottoRewards(final Lotto lotto) {
        return LottoRewards.getLottoRewards(winningNumber.countMatchCount(lotto));
    }
}
