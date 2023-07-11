package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> lottoNumbers, int bonus) {
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusBall = new LottoNumber(bonus);
        validateDuplicate(this.winningLotto, this.bonusBall);
    }

    private void validateDuplicate(Lotto lottoNumbers, LottoNumber bonus) {
        if (lottoNumbers.isContain(bonus)) {
            throw new IllegalStateException("당첨 번호와 보너스 볼은 중복되면 안됩니다.");
        }
    }
}
