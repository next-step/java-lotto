package lotto.domain;

import java.util.Set;

public class WinningLottery {
    private final Lottery winningLottery;
    private final LottoNumber bonusNumber;

    public WinningLottery(Set<Integer> inputWinningNumbers, int bonusNumber) {
        this(new Lottery(inputWinningNumbers), new LottoNumber(bonusNumber));
    }

    public WinningLottery(Lottery winningLottery, LottoNumber bonusNumber) {
        if (winningLottery.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨로또에는 보너스번호가 포함될 수 없습니다");
        }

        this.winningLottery = winningLottery;
        this.bonusNumber = bonusNumber;
    }

    public Lottery getWinningLottery() {
        return winningLottery;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
