package lotto.domain;

import lotto.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private static final int FIRST_PURCHASE_COUNT = 0;
    private static final int WINNING_COUNT = 1;

    public void create(PurchaseAmount purchaseAmount) {
        int maxPurchases = purchaseAmount.purchases();

        for (int currentPurchase = FIRST_PURCHASE_COUNT; currentPurchase < maxPurchases; currentPurchase++) {
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
            Integer currentCount = winnerRanks.get(winnerInfo);
            winnerRanks.put(winnerInfo, currentCount + WINNING_COUNT);
        });
        return winnerRanks;
    }

    public List<Lotto> findAll() {
        return this.lottos;
    }

}
