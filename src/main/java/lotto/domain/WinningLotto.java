package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank getRank(Lotto lotto) {
        return Rank.findRank(match(lotto), matchBonusNumber(lotto));
    }

    public int getReward(Lotto lotto) {
        return Rank.findReward(match(lotto), matchBonusNumber(lotto));
    }

    private int match(Lotto lotto) {
        return this.lotto.match(lotto);
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
