package lotto.ui;

import lotto.domain.lotto.LottoNumbers;

public class WinningRequestDto {
    private LottoNumbers lottoNumbers;
    private int bonusNumber;

    public WinningRequestDto(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
