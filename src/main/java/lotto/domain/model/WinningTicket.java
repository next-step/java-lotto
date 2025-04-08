package lotto.domain.model;

import java.util.List;

public class WinningTicket {
    private final List<LottoNumber> winNumbers;
    private final LottoNumber bonusNumber;

    public WinningTicket(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number must not be in winning numbers.");
        }
    }

    public List<LottoNumber> getWinNumbers() {
        return winNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
