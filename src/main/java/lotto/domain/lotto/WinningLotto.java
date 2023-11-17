package lotto.domain.lotto;

import lotto.constants.Winning;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validation(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return of(Lotto.of(numbers), LottoNumber.of(bonusNumber));
    }

    public static WinningLotto of(Lotto lotto, LottoNumber lottoNumber) {
        return new WinningLotto(lotto, lottoNumber);
    }

    private void validation(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 당첨번호 안에 포함될 수 없습니다.");
        }
    }

    public Winning match(Lotto lotto) {
        return Winning.of(matchCount(lotto), bonusMatch(lotto));
    }

    private long matchCount(Lotto lotto) {
        return lotto.matchCount(winningLotto);
    }

    private boolean bonusMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
