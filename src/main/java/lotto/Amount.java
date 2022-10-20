package lotto;

import java.util.ArrayList;
import java.util.List;

public class Amount {

    private final int amount;

    public Amount(int amount) {
        validateAmountUnderZero(amount);
        this.amount = amount;
    }

    private void validateAmountUnderZero(int amount) {
        if (amount <= 0) {
            throw new LotteryGameException(ErrorCode.AMOUNT_UNDER_ZERO);
        }
    }

    public LotteryTickets createTickets(LotteryTicketAutoGenerator lotteryTicketAutoGenerator) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lotteryTickets.add(lotteryTicketAutoGenerator.generate());
        }
        return new LotteryTickets(lotteryTickets);
    }
}
