package lotto.models;

import lotto.models.request.WinningLottoRequest;
import lotto.validator.WinningLottoRequestValidator;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLotto from(WinningLottoRequest winningLottoRequest) {
        WinningLottoRequestValidator.validate(winningLottoRequest);

        return new WinningLotto(Lotto.of(winningLottoRequest.getWinningNumber().getNumber()), winningLottoRequest.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return this.lotto.getNumbers();
    }
}
