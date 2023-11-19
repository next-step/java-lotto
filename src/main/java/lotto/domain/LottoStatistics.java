package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private static final double NUMBER_FOR_RATE = 100.0;

    private Map<Integer, LottoMatchInformation> information  = new HashMap<>();
    private double rate;

    public LottoStatistics(int purchaseAmount, MatchNumbers matchNumbers) {
        for (LottoMatchInformation matchInformation : LottoMatchInformation.values()) {
            this.information.put(matchInformation.getMatch(), matchInformation);
        }

        matchNumbers(matchNumbers);
        calculateRate(purchaseAmount);
    }

    private void matchNumbers(MatchNumbers matchNumbers) {
        for (int i=0; i<matchNumbers.size(); i++) {
            tryAddCount(matchNumbers, i);
        }
    }

    private void tryAddCount(MatchNumbers matchNumbers, int index) {
        LottoMatchInformation getInformation = information.get(matchNumbers.get(index));
        if (getInformation == null) {
            return;
        }
        getInformation.addCount();
    }

    private double totalPrize() {
        return information.values().stream().mapToDouble(LottoMatchInformation::calculatePrize).sum();
    }

    private void calculateRate(int purchaseAmount) {
        double totalPrize = totalPrize();
        this.rate = Math.round(totalPrize / purchaseAmount * NUMBER_FOR_RATE) / NUMBER_FOR_RATE;
    }

    public Map<Integer, LottoMatchInformation> getInformation() {
        return this.information;
    }

    public double getRate() {
        return this.rate;
    }
}
