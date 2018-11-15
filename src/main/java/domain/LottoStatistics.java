package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private WinningLotto winningLotto;

    public LottoStatistics(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoResult match(List<Lotto> lottos) {
        return new LottoResult(getRanks(lottos));
    }

    private List<Rank> getRanks(List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.getMatchRank(winningLotto));
        }
        return ranks;
    }
}
