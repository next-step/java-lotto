package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumbers;

public class BonusBall {
    private final int bonusNumber;

    private BonusBall(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public static BonusBall createBy(int bonusNumber, LottoTicket winningTicket) {
        validateContainsWinningTicket(winningTicket, bonusNumber);
        return new BonusBall(bonusNumber);
    }

    private void validateBonusNumber() {
        LottoNumbers.validNumberRange(bonusNumber);
    }

    private static void validateContainsWinningTicket(LottoTicket winningTicket, int bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
