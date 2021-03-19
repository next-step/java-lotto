package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

public class WinningLotto {

    public static final String GUIDE_DONT_CONTAINS_BONUS_NUMBER = "보너스 번호는 당첨 번호에 포함될 수 없습니다.";
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final List<LottoNumber> lottoNumberList, final LottoNumber bonusNumber) {
        this(new Lotto(lottoNumberList), bonusNumber);
    }

    public WinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        if(winningLotto.contains(bonusNumber)) {
            throw new LottoException(GUIDE_DONT_CONTAINS_BONUS_NUMBER);
        }
        this.bonusNumber = bonusNumber;
    }

    public LottoMatch match(final Lotto lotto) {
        long count = winningLotto.match(lotto);
        boolean hasBonus = lotto.contains(bonusNumber);
        return LottoMatch.of(count, hasBonus);
    }

    public long winningReward(final Lotto lotto) {
        return match(lotto).getWinningReward();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto)
                && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }

    @Override
    public String toString() {
        return String.format("%s %s", winningLotto, bonusNumber);
    }
}
