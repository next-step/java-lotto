package lotto.domain;

import lotto.constant.LottoRank;

public class WinningNumbers {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
        if (this.winningLottoNumbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public LottoRank findRank(LottoNumbers lottoNumbers) {
        int matchCount = lottoNumbers.getCountOfMatchingNumber(this.winningLottoNumbers);
        boolean resultBonus = lottoNumbers.contains(this.bonusNumber);
        return LottoRank.valueOf(matchCount, resultBonus);
    }
}
