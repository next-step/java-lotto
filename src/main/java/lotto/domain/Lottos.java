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
        List<Integer> matchCounts = this.lottos.stream()
                .map(lotto -> lotto.match(winnerNumbers))
                .collect(Collectors.toList());

        Map<Winner, Integer> winnerRanks = Winner.makeWinnerMap();
        matchCounts.forEach(matchCount -> {
            Winner winnerInfo = Winner.find(matchCount);
            Integer count = winnerRanks.get(winnerInfo);
            winnerRanks.put(winnerInfo, count + 1);
        });
        return winnerRanks;
    }

    public List<Lotto> findAll() {
        return this.lottos;
    }

}
