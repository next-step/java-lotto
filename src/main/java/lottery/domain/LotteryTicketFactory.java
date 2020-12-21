package lottery.domain;

public class LotteryTicketFactory {
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;

    private LotteryTicketFactory() {
        throw new AssertionError("해당 클래스는 객체를 생성할 수 없습니다.");
    }

    public static LotteryTicket createLotteryTicket(BuyBehavior buyBehavior) {
        return LotteryTicket.of(buyBehavior.getLotteryNumbers(NUMBER_OF_LOTTERY_NUMBERS));
    }
}
