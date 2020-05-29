package lottery.domain;

public class LotteryStore {

    private LotteryStore() {
    }

    public static LotteryStore getInstance() {
        return new LotteryStore();
    }

    public LotteryTicketsGroup publishLotteryTicketsGroup(PurchasePrice purchasePrice) {
        //List<LotteryTicket> lotteryTickets = Stream.generate(LotteryTicket)
        //       .limit(purchasePrice.getPurchasableLotteryTicketCounts())
        //       .collect(Collectors.toList());
        return null;
    }
}
