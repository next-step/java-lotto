package step2.domain.check;

import step2.domain.lotto.Lotto;
import step2.exception.LottoNullPointerException;

import java.util.Objects;

public final class LottoWinningCheckMachine {

    private final Lotto winningLotto;

    private LottoWinningCheckMachine(Lotto winningLotto) {
        validate(winningLotto);
        this.winningLotto = winningLotto;
    }

    public static final LottoWinningCheckMachine of(Lotto winningLotto) {
        return new LottoWinningCheckMachine(winningLotto);
    }

    private final void validate(Lotto winningLotto) {
        if (Objects.isNull(winningLotto)) {
            throw new LottoNullPointerException();
        }
    }

}
