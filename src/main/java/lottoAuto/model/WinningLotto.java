package lottoAuto.model;

import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusBall;

    public WinningLotto(Lotto winningLotto, int bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public int countWinningLottoNumbers(Set<LottoNumber> lottoNumbers) {
        return (int) winningLotto.getLottoNumbers().stream()
                .filter((winningLottoNumber) -> hasWinningLottoNumber(winningLottoNumber, lottoNumbers))
                .count();
    }

    private boolean hasWinningLottoNumber(LottoNumber winningLottoNumber, Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isNumber(winningLottoNumber.getLottoNumber()));
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
