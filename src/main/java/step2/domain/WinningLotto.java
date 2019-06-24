package step2.domain;

import java.util.Optional;

public class WinningLotto {
    private final Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    private WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return new Lotto(lotto);
    }

    public Optional<BonusNumber> getBonusNumber() {
        return Optional.ofNullable(bonusNumber);
    }

    public WinningLotto addBounsNumber(BonusNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
