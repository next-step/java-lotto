package lotto.domain;

import java.util.List;

public class LottoAdmin {
    private Lotto winningLotto;

    public LottoAdmin() {
        this.winningLotto = new Lotto();
    }

    public LottoAdmin(List<Integer> nums) {
        this.winningLotto = new Lotto(nums);
    }

    public Rank calculateRank(Lotto lotto) {
        int result = 0;
        for(Integer num : lotto.getNums()) {
            result += winningLotto.contains(num) ? 1 : 0;
        }
        return Rank.of(result);
    }
}
