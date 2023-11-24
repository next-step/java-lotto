package step2.lotto.domain;

import java.util.Set;

public class LottoWin {

    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public LottoWin(final Set<Integer> lottoWinNumbers, final int bonusNumber) {
        validateDuplicateLottoNumber(lottoWinNumbers, bonusNumber);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
        this.winLotto = Lotto.of(lottoWinNumbers);
    }

    private void validateDuplicateLottoNumber(Set<Integer> lottoWinNumbers, int bonusNumber) {
        if (lottoWinNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 입력하신 당첨 번호 내에 존재합니다.");
        }
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int matchCount(final Lotto lotto) {
        return (int) winLotto.getLottoNumbers().stream()
            .filter(lottoNumber -> lotto.getLottoNumbers().contains(lottoNumber))
            .count();
    }

    public boolean matchBonusNumber(final Lotto lotto) {
        return lotto.getLottoNumbers().stream()
            .anyMatch(lottoNumber -> lotto.getLottoNumbers().contains(bonusNumber));
    }
}
