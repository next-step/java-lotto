package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(Set<LottoNumber> winningNumbers, LottoNumber bonusLottoNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.findRank(getMatchNumbers(lotto), hasBonusNumber(lotto));
    }

    public int getMatchNumbers(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusLottoNumber);
    }
}
