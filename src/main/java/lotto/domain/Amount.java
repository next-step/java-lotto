package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
