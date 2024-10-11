package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankGroup {
    private final Map<LottoRank, LottoBundle> lottoRankGroup;

    public LottoRankGroup() {
        this.lottoRankGroup = new HashMap<>();
        lottoRankGroup.put(LottoRank.first(), new LottoBundle());
        lottoRankGroup.put(LottoRank.third(), new LottoBundle());
        lottoRankGroup.put(LottoRank.fourth(), new LottoBundle());
        lottoRankGroup.put(LottoRank.fifth(), new LottoBundle());
        lottoRankGroup.put(LottoRank.none(), new LottoBundle());
    }

    public void addLotto(final LottoRank rank, final Lotto lotto) {
        lottoRankGroup.get(rank).add(lotto);
    }

    public LottoBundle getLottoBundleByRank(final LottoRank rank) {
        return lottoRankGroup.get(rank);
    }
}
