package lotto.domain;

import java.util.List;

public class WinningTicket {
    private final List<LottoNumber> winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningTicket(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningLottoNumbers, bonusNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }
}
