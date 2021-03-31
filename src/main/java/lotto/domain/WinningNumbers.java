/*
 * 당첨 번호를 보유하고 로또번호와 매치시키는 클래스
 * */
package lotto.domain;

import java.util.Objects;

public class WinningNumbers {

    private LottoNumbers winningNumbers;

    public WinningNumbers(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    /*
    * 로또 당첨 여부를 판단하여 Rank를 반환한다
    * */
    public Rank matches(Lotto lotto) {
        return Rank.matchRank(lotto.contains(winningNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
