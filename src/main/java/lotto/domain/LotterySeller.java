package lotto.domain;

public class LotterySeller {

    private int lotteryTicketPrice;

    public LotterySeller(int lotteryTicketPrice) {
        this.lotteryTicketPrice = lotteryTicketPrice;
    }

    public LotterySeller() {
        this(1000);
    }

//    public LotteryTicketList buy(int amountOfMoney) {
//        int numberOfTickets = amountOfMoney / lotteryTicketPrice;
//        return new LotteryTicketList(numberOfTickets, lotteryTicketPrice);
//    }

    public int getLotteryTicketPrice() {
        return lotteryTicketPrice;
    }

    public void changeLotteryTicketPrice(int price) {
        this.lotteryTicketPrice = price;
    }
}
