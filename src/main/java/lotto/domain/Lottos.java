package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException("로또를 한 장 이상 구매하세요.");
        }
        this.lottos = lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    public Map<PrizeType, Integer> countMatch(Numbers prizeNumbers) {
        Map<PrizeType, Integer> prizeStat = new HashMap<>();
        this.lottos.forEach(lotto -> {
            PrizeType prizeType = PrizeType.of(lotto.countMatch(prizeNumbers));
            prizeStat.put(prizeType, prizeStat.getOrDefault(prizeType, 0) + 1);
        });
        return prizeStat;
    }
}
