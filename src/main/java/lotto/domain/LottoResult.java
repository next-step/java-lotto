package lotto.domain;

import java.util.Map;

public class LottoResult {

    public static final int FIRST_PRIZE = 2000000000;
    public static final int FIRST = 6;
    public static final int SECOND_PRIZE = 1500000;
    public static final int SECOND = 5;
    public static final int THIRD_PRIZE = 50000;
    public static final int THIRD = 4;
    public static final int FOURTH_PRIZE = 5000;
    public static final int FOURTH = 3;

    private final Map<Integer, Integer> value;
    private final int purchaseCount;

    public LottoResult(Map<Integer, Integer> lottoResult, int purchaseCount) {
        this.value = lottoResult;
        this.purchaseCount = purchaseCount;
    }

    public float getEarningRate() {

        int totalPrize = (value.getOrDefault(FIRST, 0) * FIRST_PRIZE)
                + (value.getOrDefault(SECOND, 0) * SECOND_PRIZE)
                + (value.getOrDefault(THIRD, 0) * THIRD_PRIZE)
                + (value.getOrDefault(FOURTH, 0) * FOURTH_PRIZE);

        return  totalPrize / (float) (purchaseCount * Lotto.PRICE);
    }

    public int getFirstCount() {
        return value.get(FIRST);
    }

    public int getSecondCount() {
        return value.get(SECOND);
    }

    public int getThirdCount() {
        return value.get(THIRD);
    }

    public int getFourthCount() {
        return value.get(FOURTH);
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
