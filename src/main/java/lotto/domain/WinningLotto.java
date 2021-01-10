package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(List<Integer> lotto, int bonusNo) {
        this.lotto = new Lotto(lotto);
        this.bonusNo = LottoNumber.of(bonusNo);

        if(this.lotto.contains(this.bonusNo)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호와 중복될 수 없습니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        long count = this.lotto.match(userLotto);
        boolean isBonus = userLotto.contains(bonusNo);

        return Rank.valueOf(count, isBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNo, that.bonusNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNo);
    }
}
