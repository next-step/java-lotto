package study.ascii92der.lotto.step3to5;

import java.util.List;

public class WinningLotto {

    public static final String ERROR_MASSAGE_DUPLICATE_NUMBER_WITH_WINNING_LOTTO = "bonus number is duplicated with winning lotto";
    private final Lotto winningLotto;
    private final LottoNumber lottoNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonus) {
        this(new Lotto(lottoNumbers), new LottoNumber(bonus));
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.lottoNumber = bonusNumber;
        validBonus();
    }

    private void validBonus() {
        if (winningLotto.contains(lottoNumber)) {
            throw new IllegalArgumentException(ERROR_MASSAGE_DUPLICATE_NUMBER_WITH_WINNING_LOTTO);
        }
    }

    public int match(Lotto lotto) {
        return this.winningLotto.match(lotto);
    }

    public boolean isMatchedBonus(Lotto lotto) {
        return lotto.contains(lottoNumber);
    }
}
