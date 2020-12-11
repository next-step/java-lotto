package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoAdmin {
    private Lotto winningLotto;

    private LottoAdmin() {
        this.winningLotto = new Lotto();
    }

    public LottoAdmin(List<Integer> nums) {
        this.winningLotto = new Lotto(nums);
    }

    public LottoAdmin(String nums) {
        this.winningLotto = new Lotto(nums);
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.of(winningLotto.getMatchNums(lotto));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAdmin that = (LottoAdmin) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}
