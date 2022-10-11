package lotto.models;

import lotto.models.request.WinningLottoRequest;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    private WinningLotto(LottoNumbers lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(WinningLottoRequest winningLottoRequest) {
        return new WinningLotto(LottoNumbers.of(winningLottoRequest.getWinningNumber()), winningLottoRequest.getBonusNumber());
    }
}
