package step4.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, LottoNumber bonusNo) {
        if(lotto.hasNumber(bonusNo)) {
            throw new IllegalArgumentException();
        }
        this.bonusNo = bonusNo;
        this.lotto = lotto;
    }

    public List<Rank> getResult(Lottos lottos) {
        List<Rank> ranks = new ArrayList<>();
        for(Lotto lotto : lottos.getLottos()) {
            addRank(ranks, lotto.getRank(this.lotto, this.bonusNo));
        }

        return ranks;
    }

    private void addRank(List<Rank> ranks, Rank rank) {
        if (rank != Rank.MISS) {
            ranks.add(rank);
        }
    }
}
