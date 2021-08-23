package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lottos {

    private static final int FIRST_PURCHASE_COUNT = 0;
    private static final int ADD_COUNT = 1;
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

    public Map<Rank, Integer> findRanks(Numbers winnerNumbers, Numbers bonusNumbers) {
        Map<Rank, Integer> rankInfos = Rank.makeWinnerRank();
        for (Lotto lotto : lottos) {
            Rank rankInfo = lotto.match(winnerNumbers, bonusNumbers);
            Integer currentCount = rankInfos.get(rankInfo);
            rankInfos.put(rankInfo, currentCount + ADD_COUNT);
        }
        return rankInfos;
    }

    public List<Lotto> findAll() {
        return this.lottos;
    }

}
