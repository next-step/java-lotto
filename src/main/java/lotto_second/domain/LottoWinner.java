package lotto_second.domain;

import lotto_second.util.LottoValidate;

import java.util.Set;

public class LottoWinner {
    private final Set<LottoNumber> winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinner(String input, String bonusNumber) {
        this.winnerNumbers = LottoValidate.validateLottoNumbers(LottoValidate.parseLottoNumbers(input));
        this.bonusNumber = new LottoNumber(LottoValidate.parseLottoNumber(bonusNumber));
    }

    public void numberDuplicateInspection() {
        if (this.winnerNumbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    public Set<LottoNumber> getWinnerNumbers() {
        return winnerNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
