package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> winningLottos;
    private final LottoNumber bonusBall;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLottos = winningLotto.getLottoNumbers();
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(Lotto winningLotto, LottoNumber bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    public List<LottoNumber> getWinningLottoNumbers() {
        return winningLottos;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
