package lotto.step3.domain;

import java.util.Set;

public class Winning {
    private Lottery winnerNumber;
    private LottoNumber bonusNumber;

    public Winning(Lottery winnerNumber, LottoNumber bonusNumber) {
        if (winnerNumber.getLottery().size() != Lottery.LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는" + Lottery.LOTTO_COUNT + "개 이어야 합니다.");
        }

        if (winnerNumber.getLottery().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호에 없는 숫자 이어야 합니다.");
        }
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lottery getWinnerNumber() {
        return winnerNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
