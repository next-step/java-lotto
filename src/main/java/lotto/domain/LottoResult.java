package lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    final static int PRICE = 1000;

    private Map<ProfitRule, Integer> result;
    private int profit;
    private int payment;
    private BigDecimal profitRatio;

    public LottoResult(int lottoTickets) {
        this.payment = lottoTickets * PRICE;
        result = new LinkedHashMap<>();
        for (ProfitRule p : ProfitRule.values()) {
            result.put(p, 0);
        }
    }

    public Map<ProfitRule, Integer> getResult() {
        return result;
    }

    public int getProfit() {
        return profit;
    }

    public int getPayment() {
        return payment;
    }

    public void saveLottoResult(long matchingScore) {
        if (matchingScore > 2) {
            ProfitRule profitRule = ProfitRule.getProfitByMatchingScore(matchingScore);
            result.put(profitRule, result.get(profitRule) + 1);
            profit += profitRule.getProfit();
        }
    }

    public void getProfitRatio() {

        BigDecimal.valueOf(getProfit()/getPayment());
    }
}
