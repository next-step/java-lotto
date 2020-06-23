package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoResult {

    private static final int LOTTO_GAME_PRICE = 1000;
    private static final int INIT_ZERO = 0;
    private static final int PRIZE_MIN_MATCH_COUNT = 3;
    private static final float BREAK_EVEN_POINT = 1.0f;
    private static final int ADD_COUNT_ONE =1;
    private List<Prize> rankResult;
    private Map<Prize, Integer> result;



    public WinningLottoResult() {
        rankResult = new ArrayList();
        result = new LinkedHashMap<>();
        result.put(Prize.FIFTH, INIT_ZERO);
        result.put(Prize.FOURTH, INIT_ZERO);
        result.put(Prize.THIRD, INIT_ZERO);
        result.put(Prize.SECOND, INIT_ZERO);
        result.put(Prize.FIRST, INIT_ZERO);


    }

    public void match(int count, Match match) {

        if (count > PRIZE_MIN_MATCH_COUNT) {
            Prize prize = Prize.findByPrize(count, match.isCheck());
            rankResult.add(prize);
        }
    }

    public Map<Prize, Integer> getResult() {

        for (Prize prize : this.rankResult) {

            Integer plusCount = result.get(prize) + ADD_COUNT_ONE;
            result.put(prize, plusCount);
        }

        return result;
    }


    public float getRevenueStatic(int buyCount) {
        int totalSum = getTotalSum();
        return totalSum / (buyCount * LOTTO_GAME_PRICE);
    }

    private int getTotalSum() {
        int totalSum = 0;
        for (Prize prize : this.rankResult) {
            totalSum = prize.sumMoney(totalSum);
        }
        return totalSum;
    }

    public String benefitOrLoss(float revenue) {

        if (revenue < BREAK_EVEN_POINT) {
            return "손해";
        }
        return "이득";
    }

}
