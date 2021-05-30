package step5.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto implements Matchable {

    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(List<Integer> lotto, int bonusNo) {
        this.lotto = new Lotto(lotto);
        this.bonusNo = LottoNumber.of(bonusNo);
        checkIfBonusDuplicated();

    }

    private void checkIfBonusDuplicated() {
        if (this.lotto.contains(this.bonusNo)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 포함될 수 없습니다.");
        }
    }


    public Rank match(Lotto userLotto) {
        int matchCount = lotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.rank(matchCount, matchBonus);
    }


    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                ", bonusNo=" + bonusNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                Objects.equals(bonusNo, that.bonusNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNo);
    }
}
