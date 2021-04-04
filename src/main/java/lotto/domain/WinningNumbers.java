/*
 * 당첨 번호를 보유하고 로또번호와 매치시키는 클래스
 * */
package lotto.domain;

import java.util.Objects;

import static lotto.util.Message.OVERLAP_BONUS_NUMBER;

public class WinningNumbers {

    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers winningNumbers) {
        if (winningNumbers.hasLottoSize()) {
            this.winningNumbers = winningNumbers;
        }
    }

    public WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.hasLottoSize()){
            this.winningNumbers = winningNumbers;
        }
        if (canHaveBonus(bonusNumber)) {
            this.bonusNumber = bonusNumber;
        }
    }

    /*
    * 입력한 보너스 볼이 당첨번호와 중복되는지 확인한다.
    * */
    public boolean canHaveBonus(LottoNumber bonusNumber) {
        if (winningNumbers.containsOne(bonusNumber)) {
            throw new IllegalArgumentException(OVERLAP_BONUS_NUMBER);
        }
        return true;
    }

    /*
     * 로또 당첨 여부를 판단하여 Rank를 반환한다
     * */
    public Rank matches(Lotto lotto) {
        return Rank.rank(lotto.contains(winningNumbers), lotto.containsBouns(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
