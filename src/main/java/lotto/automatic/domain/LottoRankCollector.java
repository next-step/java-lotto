package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRankCollector {

    private final List<LottoRank> rankList;

    public LottoRankCollector(List<Lotto> lottoList, WinningLotto winningLotto) {

        rankList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            rankList.add(winningLotto.getRank(lotto));
        }
    }

    public List<LottoRank> getRankList() {
        return rankList;
    }

}
