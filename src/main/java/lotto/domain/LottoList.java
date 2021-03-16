package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoList {

    private List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoStatistics makeMatchingCount(Lotto lastWeekWinningLotto) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for ( Lotto lotto : lottoList) {
            int matchingCount = lotto.containsCount(lastWeekWinningLotto);
            LottoRank rank = LottoRank.findByMatchingCount(matchingCount);
            lottoStatistics.put(rank);
        }
        return lottoStatistics;
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
