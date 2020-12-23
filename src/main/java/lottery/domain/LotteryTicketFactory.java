package lottery.domain;

public class LotteryTicketFactory {
    private LotteryTicketFactory() {
        throw new AssertionError("해당 클래스는 객체를 생성할 수 없습니다.");
    }

    public static LotteryTicket createLotteryTicket(BuyBehavior buyBehavior) {
        return LotteryTicket.of(buyBehavior.getLotteryNumbers());
    }

    public static LotteryTicket createLotteryTicketBy(BuyBehavior behavior, String string) {
        return LotteryTicket.of(behavior.getLotteryNumbersBy(string));
    }
}
