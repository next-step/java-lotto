package domain;

import util.Calculator;

import static constant.LotteryRules.DEFAULT_LOTTERY_TICKET_PRICE;

public class TicketCountService {

    public long countOfLotteryTickets(long amount) {
        return (long) Calculator.divide(amount, DEFAULT_LOTTERY_TICKET_PRICE);
    }

}
