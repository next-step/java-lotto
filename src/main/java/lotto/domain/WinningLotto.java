package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private final Lotto winnerLotto;
    private final Number bonusNumber;

    private WinningLotto(final Lotto winnerLotto, final Number bonusNumber) {

        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(final String winningLotto, final String bonusNumber) {

        validate(winningLotto, bonusNumber);

        return new WinningLotto(Lotto.from(winningLotto), Number.from(bonusNumber));
    }

    private static void validate(final String winningLotto, final String bonusNumber) {

        if (winningLotto == null || winningLotto.isBlank() || bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    public List<Number> getWinnerLotto() {

        return Collections.unmodifiableList(this.winnerLotto.getLotto());
    }

    public Number getBonusNumber() {

        return bonusNumber;
    }
}
