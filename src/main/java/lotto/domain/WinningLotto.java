package lotto.domain;


public class WinningLotto extends Lotto {
    public final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
    }
}
