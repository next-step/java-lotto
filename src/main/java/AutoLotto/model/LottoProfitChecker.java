package autoLotto.model;

public class LottoProfitChecker {

    private float profit;

    private static final Long INIT_BENEFIT = 0L;
    private static final int LOTTO_PRIZE_START_INDEX = 1;
    private static final int LOTTO_PRIZE_END_LENGTH = 4;

    public LottoProfitChecker(int[] winLottos, String purchaseAmount) {
        Long totalWinAmount = getTotalPrizes(winLottos);
        float purchaseAmountAsFloat = stringToFloat(purchaseAmount);
        this.profit = getProfit(totalWinAmount, purchaseAmountAsFloat);
    }

    private Long getTotalPrizes(int[] winLottos) {
        Long totalWinAmount = INIT_BENEFIT;

        for (int i = LOTTO_PRIZE_START_INDEX; i <= LOTTO_PRIZE_END_LENGTH; i++) {
            totalWinAmount += (getPrizeAmount(i) * winLottos[i]);
        }

        return totalWinAmount;
    }

    private Long getPrizeAmount(int index) {
        return PrizeResultEnum.getPrizeByIndex(index);
    }

    private float stringToFloat(String string) {
        return Float.parseFloat(string);
    }

    private float getProfit(Long winAmount, float purchaseAmount) {
        if (winAmount == INIT_BENEFIT) {
            return 0f;
        }

        float profit = (float) winAmount / purchaseAmount;
        return profit;
    }

    public float getProfit() {
        return profit;
    }
}
