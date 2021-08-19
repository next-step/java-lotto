package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private static final int FIRST_PURCHASE_COUNT = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void create(PurchaseAmount purchaseAmount) {
        int maxPurchases = purchaseAmount.purchases();

        for (int currentPurchase = FIRST_PURCHASE_COUNT; currentPurchase < maxPurchases; currentPurchase++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public int count() {
        return lottos.size();
    }

    public Map<Rank, Integer> findWinners(Numbers winnerNumbers) {
        List<Integer> matchCounts = this.lottos.stream()
                .map(lotto -> lotto.match(winnerNumbers))
                .filter(matchCount -> matchCount != 0)
                .collect(Collectors.toList());

        return Rank.findWinningInfo(matchCounts);
    }

    public List<Lotto> findAll() {
        return this.lottos;
    }

}
