package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto otherLotto) {
        return lotto.matchCount(otherLotto);
    }

    public boolean matchBonus(Lotto otherLotto) {
        return otherLotto.contains(bonusNumber);
    }
}
