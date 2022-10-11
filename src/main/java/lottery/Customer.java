package lottery;

public class Customer {

    private final LotteryWallet lotteryWallet = new LotteryWallet();

    public int purchase(int cashAmount) {
        int availablePurchaseLotteryCount = LotteryCompany.getAvailablePurchaseLotteryCount(cashAmount);
        lotteryWallet.generateLottery(availablePurchaseLotteryCount);

        return availablePurchaseLotteryCount;
    }

    public LotteryWallet getLotteryWallet() {
        return lotteryWallet;
    }
}
