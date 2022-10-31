package lotto.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int TWO_DECIMAL_PLACES = 2;

    private static final Map<Rank, Integer> lottoResultSet = new HashMap<>();
    private String prizeRate;

    static {
        for (Rank rank : Rank.values()) {
            lottoResultSet.put(rank, 0);
        }
    }

    public void addWinningResult(Rank rank) {
        int currentResult = lottoResultSet.get(rank);
        lottoResultSet.put(rank, currentResult + 1);
    }

    public int getResultByRank(Rank rank) {
        return lottoResultSet.get(rank);
    }

    public void calculatePrizeRate(PaidAmount paidAmount) {
        double rate = (double) calculateTotalPrize() / paidAmount.getPaidAmount();

        DecimalFormat decimal = new DecimalFormat();
        decimal.setMaximumFractionDigits(TWO_DECIMAL_PLACES);

        this.prizeRate = decimal.format(rate);
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : lottoResultSet.entrySet()) {
            totalPrize += (entry.getKey().getPrize() * entry.getValue());
        }
        return totalPrize;
    }

    public String getPrizeRate() {
        return this.prizeRate;
    }
}
