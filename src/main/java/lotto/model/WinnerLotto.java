package lotto.model;

import java.util.Objects;

public class WinnerLotto {

    private final Lotto winnerLotto;
    private final LottoNumber bonusNumber;

    public WinnerLotto(Lotto winnerLotto, LottoNumber bonusNumber) {
        validate(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winnerLotto, LottoNumber bonusNumber) {
        Objects.requireNonNull(winnerLotto, "당첨 로또를 올바르게 입력해주세요. winnerLotto is null");
        Objects.requireNonNull(bonusNumber, "보너스 로또 번호를 올바르게 입력해주세요. bonusNumber is null");

        if (winnerLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 로또 번호와 보너스 번호는 같을 수 없습니다. winnerLotto: " + winnerLotto.get() + ", bonusNumber: " + bonusNumber);
        }
    }

    public Rank getRank(Lotto lotto) {
        return Rank.of(lotto.getMatchCount(this.winnerLotto), lotto.contains(bonusNumber));
    }
}
