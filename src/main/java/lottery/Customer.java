package lottery;

public class Customer {

    private final LotteryWallet lotteryWallet = new LotteryWallet();

    public void purchase(int cashAmount) {
        int availablePurchaseLotteryCount = LotteryCompany.getAvailablePurchaseLotteryCount(cashAmount);
        lotteryWallet.generateLottery(availablePurchaseLotteryCount);
    }

    public LotteryWallet getLotteryWallet() {
        return lotteryWallet;
    }
}
