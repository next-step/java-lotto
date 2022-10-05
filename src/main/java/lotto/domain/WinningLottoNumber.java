package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLottoNumber {

    private final LottoNumber winnerLottoNumber;
    private final Number bonusNumber;

    private WinningLottoNumber(final LottoNumber winnerLottoNumber, final Number bonusNumber) {

        this.winnerLottoNumber = winnerLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoNumber from(final String winningLotto, final String bonusNumber) {

        validate(winningLotto, bonusNumber);

        return new WinningLottoNumber(LottoNumber.from(winningLotto), Number.from(bonusNumber));
    }

    private static void validate(final String winningLotto, final String bonusNumber) {

        if (winningLotto == null || winningLotto.isBlank() || bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    public List<Number> getWinnerLottoNumber() {

        return Collections.unmodifiableList(this.winnerLottoNumber.getLottoNumber());
    }

    public Number getBonusNumber() {

        return bonusNumber;
    }
}
