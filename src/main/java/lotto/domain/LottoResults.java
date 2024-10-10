package lotto.domain;

import java.util.Map;

public class LottoResults {
    private static final int FIFTH_PRIZE = 5000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int FIRST_PRIZE = 2000000000;
    private final Map<Integer, Integer> prize;

    public LottoResults(Map<Integer, Integer> prize) {
        this.prize = prize;
    }

    public void addResult(int lottoResult) {
        prize.put(lottoResult, prize.getOrDefault(lottoResult, 0) + 1);
    }

    public int getPrizeMoney() {
        return setFirstPrize() + setThirdPrize() + setFourtPrize() + setFifthPrize();
    }

    private int setFifthPrize() {
        return prize.getOrDefault(5, 0) * FIFTH_PRIZE;
    }

    private int setFourtPrize() {
        return prize.getOrDefault(4, 0) * FOURTH_PRIZE;
    }

    private int setThirdPrize() {
        return prize.getOrDefault(3, 0) * THIRD_PRIZE;
    }

    private int setFirstPrize() {
        return prize.getOrDefault(1, 0) * FIRST_PRIZE;
    }
}
