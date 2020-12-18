package lottery.domain;

public class LotteryTicketFactory {
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;

    public static LotteryTicket createLotteryTicket(BuyBehavior buyBehavior) {
        return LotteryTicket.of(buyBehavior.getLotteryNumbers(NUMBER_OF_LOTTERY_NUMBERS));
    }
}
