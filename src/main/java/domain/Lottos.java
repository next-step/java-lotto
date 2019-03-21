package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int MINIMUM_WIN_COUNT = 2;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int revenue;

    public Lottos(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public Map<Integer, Integer> produceResults() {
        Map<Integer, Integer> map = new HashMap<>();

        this.lottos.forEach(lotto -> {
            int matchCount = this.match(lotto);
            if (matchCount > this.MINIMUM_WIN_COUNT) {
                if (map.get(matchCount) == null) {
                    map.put(matchCount, 0);
                }
                map.put(matchCount, map.get(matchCount) + 1);
            }
        });
        return map;
    }

    private int match(Lotto lotto) {
        int matchCount = 0;
        for (Integer winningNumber : this.winningNumbers) {
            if (lotto.getLotto().contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
