package lotto.service;

public class LottoPurchases {

    private static final int LOTTO_BUY_AMOUNT = 1000;
    private int lottoMachineCount = 0;

    public LottoPurchases(int money){
        this.lottoMachineCount = lottoPurchasesCountCalculate(money);
    }

    public int getLottoMachineCount(){
        return lottoMachineCount;
    }

    public int lottoPurchasesCountCalculate(int lottoPurchasesAmount) {
        return lottoPurchasesAmount / LOTTO_BUY_AMOUNT;
    }
}
