package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void determineAllLottoResult(List<LottoNumber> winningNumbers) {
        lottoList.forEach((lotto) -> lotto.determineLottoResult(winningNumbers));
    }

    public Map<Rank, Integer> getStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();
        initializeStatistics(statistics);

        for (Lotto lotto : lottoList) {
            Rank rank = lotto.getRank();
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private void initializeStatistics(Map<Rank, Integer> statistics) {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int size() {
        return lottoList.size();
    }
}
