package lotto.domain;

public class LottoBuyerGenerator {
    public static final int BUY_TICKET_COST = 1_000;

    public static LottoBuyer generateLottoBuyer(int totalCost, int manualTicketCnt) {
        int totalTicketCnt = totalCost / BUY_TICKET_COST;
        if (manualTicketCnt > totalTicketCnt) {
           return new LottoBuyer(0, totalTicketCnt);
        }

        return new LottoBuyer(
            totalTicketCnt - manualTicketCnt,
            manualTicketCnt
        );
    }
}
