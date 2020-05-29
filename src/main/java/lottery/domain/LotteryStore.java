package lottery.domain;

public class LotteryStore {

    private LotteryStore() {
    }

    public static LotteryStore getInstance() {
        return new LotteryStore();
    }

    public LotteryTicketsGroup sellLotteryTicketsGroup(PurchasePrice purchasePrice) {
        return LotteryTicketsGroup.publishAutomaticLotteryTicketsGroup(purchasePrice);
    }
}
