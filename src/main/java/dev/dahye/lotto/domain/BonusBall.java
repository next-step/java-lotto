package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumber;

public class BonusBall {
    private final LottoNumber bonusNumber;

    private BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusBall of(int bonusNumber, LottoTicket winningTicket) {
        LottoNumber bonusBall = LottoNumber.of(bonusNumber);
        validateContainsWinningTicket(winningTicket, bonusBall);
        return new BonusBall(bonusBall);
    }

    private static void validateContainsWinningTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }
}
