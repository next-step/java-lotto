package step4.lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto implements Matchable{
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.winningLotto = new Lotto(lotto);
        this.bonusNumber = LottoNumber.of(bonusNumber);
        if(this.winningLotto.contains(this.bonusNumber)){
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 포함될수 없습니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = winningLotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Rank.rank(matchCount,matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
