package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLottos;
    private final int bonusBall;

    private WinningLotto(Lotto winningLotto, int bonusBall) {
        this.winningLottos = winningLotto.getLottoNumbers();
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(Lotto winningLotto, int bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottos;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
