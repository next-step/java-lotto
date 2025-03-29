package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos buy(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            this.lottos.add(new Lotto());
        }
        return this;
    }

    public Map<PrizeEnum, Integer> getSummary(List<Integer> winNumbers, int bonus) {

        Map<PrizeEnum, Integer> summaryMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            int countOfMatch = lotto.getHitCount(winNumbers);

            boolean matchBonus = lotto.hasBonusNumber(bonus);

            PrizeEnum prizeEnum = PrizeEnum.of(countOfMatch, matchBonus);

            summaryMap.put(prizeEnum, summaryMap.getOrDefault(prizeEnum, 0) + 1);
        }
        return summaryMap;
    }
}
