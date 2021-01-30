package lotto.domain;

public class LottoBuyerGenerator {
    public static final int BUY_TICKET_COST = 1_000;

    public static LottoBuyer generateLottoBuyer(int totalCost) {
        return new LottoBuyer(
            totalCost / BUY_TICKET_COST
        );
    }
}
