package lotto.automatic;

import lotto.automatic.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public List<Lotto> generateLotto(int lottoAmount) {

        List<Lotto> list = new ArrayList<>();

        for(int i = 0; i < lottoAmount; i ++ ) {
            list.add(Lotto.auto());
        }

        return list;
    }

    public LottoResult getLottoResult(int investMoney, List<LottoRank> rankList) {

        return new LottoResult(investMoney, rankList);
    }

    public List<LottoRank> getLottoRank(List<Lotto> lottoList, WinningLotto winningLottoNums) {
        LottoRankCollector collector = new LottoRankCollector(lottoList, winningLottoNums);

        return collector.getRankList();
    }
}
