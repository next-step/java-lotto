package lotto.domain;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusBall) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public LottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
