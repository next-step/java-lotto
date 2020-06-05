package lottery.domain;

public class LotteryStore {

    private LotteryStore() {
    }

    public static LotteryStore getInstance() {
        return new LotteryStore();
    }

    public LotteryTicketsGroup publishLotteryTicketsGroup(PurchasePrice purchasePrice,
                                                          ManualTicketsNumbersDto manualTicketsNumbersDto) {
        return LotteryTicketsGroup.publishLotteryTicketsGroup(purchasePrice, manualTicketsNumbersDto);
    }
}
