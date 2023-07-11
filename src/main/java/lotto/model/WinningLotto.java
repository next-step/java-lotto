package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(final List<LottoNumber> lottoNumbers, final int bonus) {
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusBall = new LottoNumber(bonus);
        validateDuplicate(this.winningLotto, this.bonusBall);
    }

    private void validateDuplicate(final Lotto lottoNumbers, final LottoNumber bonus) {
        if (lottoNumbers.isContain(bonus)) {
            throw new IllegalStateException("당첨 번호와 보너스 볼은 중복되면 안됩니다.");
        }
    }

    public Rank compare(Lotto lotto) {
        int count = (int) lotto.getLottoNumbers().stream()
                .filter(winningLotto::isContain)
                .count();
        boolean isBonus = lotto.isContain(bonusBall);
        return Rank.match(count, isBonus);
    }
}
