package lotto.domain;

public class LottoPurchases {

    private static final int LOTTO_BUY_AMOUNT = 1000;
    private static int lottoMachineCount = 0;
    private static int passivityCount = 0;
    private static int automaticCount = 0;

    public LottoPurchases(int money, int passivityCount) {
        this.lottoMachineCount = lottoPurchasesCountCalculate(money);
        this.passivityCount = passivityCount;
        this.automaticCount = lottoAutomaticCount(this.lottoMachineCount, this.passivityCount);
    }

    private int lottoPurchasesCountCalculate(int lottoPurchasesAmount) {
        lottoParchasesCheck(lottoPurchasesAmount);
        return lottoPurchasesAmount / LOTTO_BUY_AMOUNT;
    }

    private int lottoAutomaticCount(int lottoMachineCount, int passivityCount) {
        if (lottoMachineCount < passivityCount) {
            throw new IllegalArgumentException("수동 구매할 수 있는 금액이 부족");
        }
        return lottoMachineCount - passivityCount;
    }

    private void lottoParchasesCheck(int lottoPurchasesAmount) {
        if (lottoPurchasesAmount < 1000) {
            throw new IllegalArgumentException("금액부족");
        }
    }

    public int getPassivityCount() {
        return passivityCount;
    }

    public int getAutomaticCount() {
        return automaticCount;
    }
}
