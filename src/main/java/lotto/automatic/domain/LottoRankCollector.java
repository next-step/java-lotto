package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRankCollector {

    private final List<LottoRank> rankList;

    public LottoRankCollector(List<Lotto> lottoList, Lotto winnerLotto) {

        rankList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            rankList.add(LottoRank.matchCount(lotto.matchCount(winnerLotto)));
        }
    }

    public List<LottoRank> getRankList() {
        return rankList;
    }

}
