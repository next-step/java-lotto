package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void drawAutomaticLottos(Lotto luckyLotto) {
        for (Lotto lotto : lottoList) {
            lotto.drawAutomaticLotto(luckyLotto);
        }
    }

    public LottoStatistic makeStatistic() {
        Map<LottoRank, Integer> lottoStatisticMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
            LottoRank rank = LottoRank.findByWinningNumber(lotto.getMatchingCount());
            if (lottoStatisticMap.containsKey(rank)) {
                lottoStatisticMap.put(rank, lottoStatisticMap.get(rank) + 1);
                continue;
            }
            lottoStatisticMap.put(rank, 1);
        }
        return new LottoStatistic(lottoStatisticMap);
    }

    public void print() {
        lottoList.forEach(Lotto::print);
    }
}
