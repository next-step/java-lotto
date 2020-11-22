package lotto_auto.model;

import java.util.List;

public class LottoResultList {

    private final List<LottoResult> lottoResultList;

    public LottoResultList(List<LottoResult> lottoResultList) {
        this.lottoResultList = lottoResultList;
    }

    public int getRankLottoCount(int rank) {
        return (int) this.lottoResultList.stream()
                .filter(item -> item.isRank(rank))
                .count();
    }
}
