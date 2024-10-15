package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankGroup {
    private final Map<LottoRank, LottoResultBundle> lottoRankGroup;

    public LottoRankGroup() {
        this.lottoRankGroup = new HashMap<>();
        lottoRankGroup.put(LottoRank.FIRST, new LottoResultBundle());
        lottoRankGroup.put(LottoRank.SECOND, new LottoResultBundle());
        lottoRankGroup.put(LottoRank.THIRD, new LottoResultBundle());
        lottoRankGroup.put(LottoRank.FOURTH, new LottoResultBundle());
        lottoRankGroup.put(LottoRank.FIFTH, new LottoResultBundle());
        lottoRankGroup.put(LottoRank.NONE, new LottoResultBundle());
    }

    public void addLotto(final LottoRank rank, final Lotto lotto) {
        lottoRankGroup.get(rank).add(lotto);
    }

    public LottoResultBundle getLottoBundleByRank(final LottoRank rank) {
        return lottoRankGroup.get(rank);
    }
}
