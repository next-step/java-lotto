package step2;

import java.util.*;

public class LotteryAwardSystem {

    private final List<Lotto> lottos;
    private final Lotto winNumbers;
    private final int money;
    private static HashMap<Integer, Integer> prizeMap = new HashMap<>();
    private HashMap<Integer, Integer> winnersCountMap = new HashMap<>();
    private double profitRate;

    public LotteryAwardSystem(List<Lotto> lottos, Lotto winNumbers, int money) {
        this.lottos = lottos;
        this.winNumbers = winNumbers;
        this.money = money;
        initPrizeMap();
        calculateWinnersCount();
        calculateProfitRate();
    }

    private void initPrizeMap() {
        prizeMap.put(3, 5000);
        prizeMap.put(4, 50000);
        prizeMap.put(5, 1500000);
        prizeMap.put(6, 2000000000);
    }

    private void calculateWinnersCount() {
        for (Lotto lotto : lottos) {
            matchedNumbers(lotto);
        }
    }

    private void matchedNumbers(Lotto lotto) {
        List<Integer> tempNumbers = new ArrayList<>(lotto.getLottoNumbers());
        tempNumbers.retainAll(winNumbers.getLottoNumbers());
        int winsCount = tempNumbers.size();
        winnersCountMap.put(winsCount, winnersCountMap.getOrDefault(winsCount, 0) + 1);
    }

    private void calculateProfitRate() {
        double totalPrize = calculateSumPrize();
        profitRate = Math.floor(totalPrize / (double) money * 100) / 100;
    }

    private double calculateSumPrize() {
        double sum = 0;
        for (Integer key : prizeMap.keySet()) {
            int prize = prizeMap.get(key);
            sum = sum + prize * winnersCountMap.get(key);
        }
        return sum;
    }

    public Map<Integer, Integer> getWinnersCountMap() {
        return Collections.unmodifiableMap(winnersCountMap);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
