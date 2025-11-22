package lotto.domain;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
