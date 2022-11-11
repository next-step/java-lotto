package step2_pobi.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto implements Matchable {

    private static final String EXCEPTION_MESSAGE = "보너스번호는 당첨번호와 중복될 수 없습니다.";

    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(List<Integer> lotto, int bonusNo) {
        this.lotto = new Lotto(lotto);
        this.bonusNo = LottoNumber.of(bonusNo);
        if (this.lotto.contains(this.bonusNo)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public Rank match(List<Integer> userLotto) {
        int matchCount = lotto.match(new Lotto(userLotto));
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.rank(matchCount, matchBonus);
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
