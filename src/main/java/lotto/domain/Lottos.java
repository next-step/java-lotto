package lotto.domain;

import lotto.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void create(PurchaseAmount purchaseAmount) {
        int maxPurchases = purchaseAmount.purchases();

        for (int i = 0; i < maxPurchases; i++) {
            Lotto lotto = new Lotto(CollectionUtil.createRandomNumbers());
            lottos.add(lotto);
        }
    }

    public int count() {
        return lottos.size();
    }

    public Map<Winner, Integer> findWinners(List<Number> winnerNumbers) {
        List<Integer> counts = this.lottos.stream()
                .map(lotto -> lotto.match(winnerNumbers))
                .collect(Collectors.toList());

        Map<Winner, Integer> map = Winner.getWinnerMap();
        counts.forEach(matchCount -> {
            Winner winner = Winner.find(matchCount);
            Integer count = map.get(winner);
            map.put(winner, count + 1);
        });
        return map;
    }

    public List<Lotto> findAll() {
        return this.lottos;
    }

}
