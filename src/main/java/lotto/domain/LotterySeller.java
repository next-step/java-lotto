package lotto.domain;

import lotto.dto.LotteryPurchaseRequest;

public class LotterySeller {

    private static final int LOTTERY_TICKET_PRICE = 1000;

    public static LotteryTicketList purchase(LotteryPurchaseRequest purchaseRequest) {
        int numberOfTickets = purchaseRequest.countOfPurchasableTickets(LOTTERY_TICKET_PRICE);
        LotteryTicketList lotteryTicketList = new LotteryTicketList();
        lotteryTicketList.addAutoBulk(numberOfTickets, LOTTERY_TICKET_PRICE);
        lotteryTicketList.addManualBulk(purchaseRequest.getListOfManualLotteryNumberList(), LOTTERY_TICKET_PRICE);
        return lotteryTicketList;
    }
}
