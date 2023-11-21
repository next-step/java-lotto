package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private static final double NUMBER_FOR_RATE = 100.0;

    private Map<Integer, LottoMatchInformation> information = new HashMap<>();

    public LottoStatistics() {
        for (LottoMatchInformation lottoMatchInformation : LottoMatchInformation.values()) {
            information.put(lottoMatchInformation.getMatch(), lottoMatchInformation);
        }
    }

    public Map<Integer, LottoMatchInformation> getInformation() {
        return this.information;
    }
    public double getTotalPrize(LottoMatchNumbers lottoMatchNumbers) {
        double totalPrize = 0;
        Map<Integer, Integer> matchNumberMap = lottoMatchNumbers.getMatchNumberMap();
        for (Integer key : matchNumberMap.keySet()) {
            totalPrize += matchNumberMap.get(key) * information.get(key).getPrize();
        }
        return totalPrize;
    }

    public double getRate(Purchase purchase, double totalPrize) {
        return Math.round(totalPrize / purchase.getAmount() * NUMBER_FOR_RATE) / NUMBER_FOR_RATE;
    }
}
