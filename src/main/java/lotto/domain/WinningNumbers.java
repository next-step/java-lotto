package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        this(Lotto.from(lottoNumbers), new LottoNumber(bonusNumber));
    }

    public WinningNumbers(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = countMatch(userLotto);
        boolean matchBonus = hasMatchBonus(userLotto, matchCount);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int countMatch(Lotto userLotto) {
        return lotto.countMatch(userLotto);
    }

    private boolean hasMatchBonus(Lotto userLotto, int matchCount) {
        if (matchCount != 5) {
            return false;
        }
        return userLotto.contains(bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean containsInLotto(LottoNumber number) {
        return lotto.contains(number);
    }

    public boolean matchBonus(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
