package lotto.models;

import lotto.models.request.WinningLottoRequest;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    private WinningLotto(LottoNumbers lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLotto from(WinningLottoRequest winningLottoRequest) {
        LottoNumbers lottoNumbers = LottoNumbers.of(winningLottoRequest.getWinningNumber());
        return new WinningLotto(lottoNumbers, winningLottoRequest.getBonusNumber());
    }
}
