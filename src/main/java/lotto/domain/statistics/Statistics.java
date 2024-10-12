package lotto.domain.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final List<Integer> PRIZE_LIST = List.of(3, 4, 5, 6);
    private static final List<Integer> PRIZE_PRICE_LIST = List.of(5000, 50000, 1500000, 2000000000);
    private static final int LOTTO_MONEY = 1000;
    private static final int PRICE_LENGTH = 4;
    private final Map<Integer, Integer> prizeMap;

    public Statistics(Map<Integer, Integer> prizeMap) {
        this.prizeMap = prizeMap;
    }

    public List<Integer> prizeMatch() {
        List<Integer> prizeMatchCount = new ArrayList<>();
        for (int i = 0; i < PRICE_LENGTH; i++) {
            int priceCount = prizeMap.getOrDefault(PRIZE_LIST.get(i), 0);
            prizeMatchCount.add(priceCount);
        }
        return prizeMatchCount;
    }

    public double allMountPrice(int lottoPurchaseCount) {
        return Math.floor(getRatio(lottoPurchaseCount, getAllMountPrizes(prizeMatchAllMountPrice())) * 100.0) / 100.0;
    }

    private List<Integer> prizeMatchAllMountPrice() {
        List<Integer> prizeAllMountPrices = new ArrayList<>();
        for (int i = 0; i < PRICE_LENGTH; i++) {
            int priceCount = prizeMap.getOrDefault(PRIZE_LIST.get(i), 0);
            prizeAllMountPrices.add(priceCount * PRIZE_PRICE_LIST.get(i));
        }
        return prizeAllMountPrices;
    }

    private static int getAllMountPrizes(List<Integer> prizes) {
        int allMountPrizes = 0;
        for (int prize : prizes) {
            allMountPrizes += prize;
        }
        return allMountPrizes;
    }

    private double getRatio(int lottoPurchaseCount, int allMountPrizes) {
        int lottoPurchaseMoney = lottoPurchaseCount * LOTTO_MONEY;
        return (double) allMountPrizes / lottoPurchaseMoney;
    }
}
