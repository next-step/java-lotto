package step2.domain;

import java.util.Optional;

public class WinningLotto {
    private final Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return new Lotto(lotto);
    }

    public Optional<BonusNumber> getBonusNumber() {
        return Optional.ofNullable(bonusNumber);
    }

    public void addBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
