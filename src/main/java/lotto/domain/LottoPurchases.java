package lotto.domain;

public class LottoPurchases {

    private static final int LOTTO_BUY_AMOUNT = 1000;
    private static int lottoMachineCount = 0;

    public LottoPurchases(int money) {
        this.lottoMachineCount = lottoPurchasesCountCalculate(money);
    }

    public int getLottoMachineCount() {
        return lottoMachineCount;
    }

    private int lottoPurchasesCountCalculate(int lottoPurchasesAmount) {
        lottoParchasesCheck(lottoPurchasesAmount);
        return lottoPurchasesAmount / LOTTO_BUY_AMOUNT;
    }

    private void lottoParchasesCheck(int lottoPurchasesAmount) {
        if (lottoPurchasesAmount < 1000) {
            throw new IllegalArgumentException("금액부족");
        }
    }
}
