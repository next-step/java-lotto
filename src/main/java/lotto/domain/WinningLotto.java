package lotto.domain;

import lotto.constant.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final List<Integer> winNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winNumbers, int bonusNumber) {
        checkBonusNumberRange(bonusNumber);
        checkBonusDuplicate(winNumbers, bonusNumber);
        this.winNumbers = winNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private static List<LottoNumber> toLottoNumber(List<Integer> winNumbers) {
        List<LottoNumber> winLottoNumbers = new ArrayList<>();

        for (int winNumber : winNumbers) {
            winLottoNumbers.add(new LottoNumber(winNumber));
        }

        return winLottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    private void checkBonusNumberRange(int bonus) {
        if (bonus < Constants.MIN_LOTTO || bonus > Constants.MAX_LOTTO) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 값이어야 합니다.");
        }
    }

    private void checkBonusDuplicate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 중복됩니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) object;
        return Objects.equals(winNumbers, that.winNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers, bonusNumber);
    }

    public Lotto makeLotto() {
        return new Lotto(this.winNumbers);
    }
}
