package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private static final int MATCH_ONE = 1;
    private static final int NOT_MATCH_ZERO = 0;

    private final Lotto winnerLotto;
    private final Number bonusNumber;

    private WinningLotto(final Lotto winnerLotto, final Number bonusNumber) {

        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(final String winningLotto, final String bonusNumber) {

        return new WinningLotto(Lotto.from(winningLotto), Number.from(bonusNumber));
    }

    public int match(final Lotto lotto) {

        int result = 0;
        for (Number number : lotto.getLotto()) {
            result += compare(number);
        }
        return result;
    }

    private int compare(final Number number) {

        if (this.winnerLotto.getLotto().contains(number)) {
            return MATCH_ONE;
        }
        return NOT_MATCH_ZERO;
    }

    public boolean matchBonus(final Lotto lotto) {

        return lotto.getLotto()
                .contains(this.bonusNumber);
    }

    public List<Number> getWinnerLotto() {

        return Collections.unmodifiableList(this.winnerLotto.getLotto());
    }
}
