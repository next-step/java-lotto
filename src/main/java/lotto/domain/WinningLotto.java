package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.lotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(Lotto.of(numbers), LottoNumber.of(bonusNumber));
    }

    public Ranking match(Lotto lotto) {
        return lotto.findRankingByLotto(this.lotto, this.bonusNumber);
    }
}
