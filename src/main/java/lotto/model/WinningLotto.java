package lotto.model;

import java.util.Set;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusBall = bonusBall;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return winningLotto.getLottoNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
