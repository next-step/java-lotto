package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TotalLotteries {
    private static final int LOTTO_AMOUNT = 1000;
    private static final int MINIMUM_INPUT_AMOUNT = 1;
    private static final int INITIALIZATION_NUMBER = 0;

    private Lotteries lotteries;
    private int purchaseQuantity;

    public TotalLotteries(int purchaseQuantity) {
        this(String.valueOf(purchaseQuantity));
    }

    public TotalLotteries(String purchaseAmount) {
        this.lotteries = new Lotteries();

        checkPurchaseValidation(purchaseAmount);
        this.purchaseQuantity = (Integer.parseInt(purchaseAmount) / LOTTO_AMOUNT);
    }

    public void generateLotteries(Lotteries autoLotteries, Lotteries manualLotteries) {
        this.lotteries.addAll(autoLotteries);
        this.lotteries.addAll(manualLotteries);
    }

    public double calculateProfit(WinnerLottery winnerLottery) {
        int totalProfit = INITIALIZATION_NUMBER;

        int lotterySize = countPurchaseQuantity();
        for (int i = 0; i < lotterySize; i++) {
            totalProfit += Ranking.getProfit(this.lotteries.get(i), winnerLottery);
        }

        double profitRate = (double)totalProfit / ((double)(this.purchaseQuantity * LOTTO_AMOUNT));

        return Math.round(profitRate * 100) / 100.0;
    }

    public Map<String, Integer> makeAllLotteriesRank(WinnerLottery winnerLottery) {
        Map<String, Integer> ranks = getsInitializedMap();

        int lotteriesSize = this.lotteries.size();
        for (int i = 0; i < lotteriesSize; i++) {
            Ranking ranking = winnerLottery.rankLottery(lotteries.get(i));
            ranking.makeRanks(ranks);
        }

        return ranks;
    }

    public static Map<String, Integer> getsInitializedMap() {
        Map<String, Integer> ranks = new HashMap<>();

        ranks.put("first", INITIALIZATION_NUMBER);
        ranks.put("second", INITIALIZATION_NUMBER);
        ranks.put("third", INITIALIZATION_NUMBER);
        ranks.put("fourth", INITIALIZATION_NUMBER);
        ranks.put("fifth", INITIALIZATION_NUMBER);

        return ranks;
    }

    public static void checkPurchaseValidation(String purchaseAmount) {
        if (LOTTO_AMOUNT < MINIMUM_INPUT_AMOUNT) {
            throw  new IllegalArgumentException();
        }

        if (StringUtils.isEmpty(purchaseAmount)) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(purchaseAmount) < LOTTO_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int countPurchaseQuantity() {
        return this.purchaseQuantity;
    }


    public String toStringTotalLotteries() {
        return this.lotteries.toStringLotteries();
    }
}
