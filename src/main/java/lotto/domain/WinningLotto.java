package lotto.domain;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, String bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getMatchCount(Lotto lotto) {
        return this.lotto.getMatchCount(lotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }
}
