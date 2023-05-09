package lotto.domain;

import java.util.LinkedHashSet;

public class WinnerLotto {

    private Lotto lotto;

    private int bonusNumber;

    public WinnerLotto(final Lotto lotto, final int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LinkedHashSet<Integer> getLottoNumbers() {
        return lotto.getLottoNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean hasMatchNumber(int number) {
        return lotto.getLottoNumbers().contains(number);
    }

}
