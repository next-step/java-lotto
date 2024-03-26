package lotto.domain;

import java.util.List;

public class Winner {
    private Lotto lotto;

    public Winner(List<Integer> winLotto) {
        this.lotto = new Lotto(winLotto);
    }

    public long hitCount(Lotto lotto){
        return this.lotto.compareCount(lotto);
    }
}
