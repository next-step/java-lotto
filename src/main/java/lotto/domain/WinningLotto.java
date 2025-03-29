package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = LottoFactory.createManual(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        validate();
    }

    private void validate() {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 동일 할 수 없습니다.");
        }
    }

    public LottoRank getRank(Lotto lotto) {
        int matchCount = this.lotto.getMatchCount(lotto);
        boolean bonusMatch = lotto.contains(bonusNumber);

        return LottoRank.findRank(matchCount, bonusMatch);
    }
}
