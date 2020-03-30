package lotto.Domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos init(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public Map<Integer, Integer> match(List<Integer> winningNumber) {
        Map<Integer, Integer> statistics = initLottoStatistics();
        for (Lotto lotto : lottoList) {
            Integer matchCount = lotto.match(winningNumber);
            statistics.put(matchCount, statistics.get(matchCount)+1);
        }
        return statistics;
    }

    Map<Integer, Integer> initLottoStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            statistics.put(i, 0);
        }
        return statistics;
    }

    public Double revenueRate(Map<Integer, Integer> matchCountMap) {
        return null;
    }
}
