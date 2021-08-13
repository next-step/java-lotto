package lotto.domain;

import lotto.exception.WrongLottoNumberException;

public class WinnerNumberInfo {

    private final LottoTicket winnerTicket;
    private final LottoNumber bonusBallNumber;

    public WinnerNumberInfo(int[] winnerNumbers, int bonusBallNumber) {
        this.winnerTicket = LottoTicket.generateByIntegerArray(winnerNumbers);
        this.bonusBallNumber = generateBonusBallNumber(bonusBallNumber);
    }

    private LottoNumber generateBonusBallNumber(int bonusBallNumber) {
        LottoNumber bonusNumber = new LottoNumber(bonusBallNumber);
        validateBonusBallNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateBonusBallNumber(LottoNumber bonusNumber) {
        if (winnerTicket.value().contains(bonusNumber)) {
            throw new WrongLottoNumberException("보너스번호는 당첨번호와 중복될수 없습니다.");
        }
    }

    public LottoTicket getWinnerTicket() {
        return winnerTicket;
    }

    public LottoNumber getBonusBallNumber() {
        return bonusBallNumber;
    }
}
