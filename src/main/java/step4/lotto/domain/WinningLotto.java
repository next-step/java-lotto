package step4.lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.winningLotto = new Lotto(lotto);
        this.bonusNumber = bonusNumber;
    }


    public Rank match(List<Integer> userLotto) {
        int matchCount = winningLotto.match(new Lotto(userLotto));
        boolean matchBonus = userLotto.contains(bonusNumber);
        return Rank.rank(matchCount,matchBonus);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return bonusNumber == that.bonusNumber && Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
