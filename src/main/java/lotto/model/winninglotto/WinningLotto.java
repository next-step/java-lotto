package lotto.model.winninglotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private WinningLottoNumbers winningLottoNumbers;
    private BonusBall bonusBall;

    public WinningLotto(WinningLottoNumbers winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public WinningLotto(WinningLottoNumbers winningLottoNumbers, BonusBall bonusBall) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public boolean contains(int number) {
        return winningLottoNumbers.getWinningLottoNumbers()
                .contains(number);
    }

    public BonusBall getBonusNum() {
        return bonusBall;
    }

    public static WinningLotto of(WinningLottoNumbers winningLottoNumbers) {
        return new WinningLotto(winningLottoNumbers);
    }

    public static WinningLotto of(WinningLottoNumbers winningLottoNumbers, BonusBall bonusBall) {
        return new WinningLotto(winningLottoNumbers, bonusBall);
    }
}