package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankGroup {
    private final Map<LottoRank, LottoBundle> lottoRankGroup;

    public LottoRankGroup() {
        this.lottoRankGroup = new HashMap<>();
        lottoRankGroup.put(LottoRank.FIRST, new LottoBundle());
        lottoRankGroup.put(LottoRank.SECOND, new LottoBundle());
        lottoRankGroup.put(LottoRank.THIRD, new LottoBundle());
        lottoRankGroup.put(LottoRank.FOURTH, new LottoBundle());
        lottoRankGroup.put(LottoRank.FIFTH, new LottoBundle());
        lottoRankGroup.put(LottoRank.NONE, new LottoBundle());
    }

    public void addLotto(final LottoRank rank, final Lotto lotto) {
        lottoRankGroup.get(rank).add(lotto);
    }

    public LottoBundle getLottoBundleByRank(final LottoRank rank) {
        return lottoRankGroup.get(rank);
    }
}
