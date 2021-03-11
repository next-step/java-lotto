package lotto.domain;

public class LotterySeller {

    private static final int LOTTERY_TICKET_PRICE = 1000;

    public LotteryTicketList buy(int amountOfMoney) {
        int numberOfTickets = amountOfMoney / LOTTERY_TICKET_PRICE;
        LotteryTicketList lotteryTicketList = new LotteryTicketList();
        lotteryTicketList.addAutoBulk(numberOfTickets,LOTTERY_TICKET_PRICE);
        return lotteryTicketList;
    }


}
