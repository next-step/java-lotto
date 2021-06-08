package lotto.domain;

import java.util.List;

public class WinLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank matchCount(Lotto other) {
        boolean bonusMatch = other.containsNumber(bonusNumber);
        return lotto.matchCount(other, bonusMatch);
    }
}
