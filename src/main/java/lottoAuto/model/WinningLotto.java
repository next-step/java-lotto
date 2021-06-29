package lottoAuto.model;

import java.util.Collections;
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
                .filter(lottoNumbers::contains)
                .count()
                ;
    }

    public boolean hasBonusBall(){
        return winningLotto.getLottoNumbers().stream()
                .anyMatch(lottoNumber -> lottoNumber.hasNumber(bonusBall));
    }
}
