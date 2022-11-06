package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import lotto.strategy.AutoGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Amount {

    private final int amount;

    public Amount(int amount) {
        validateAmountUnderZero(amount);
        this.amount = amount;
    }

    public Amount(String amount) {
        this(parseInt(amount));
    }

    private static int parseInt(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new LotteryGameException(ErrorCode.NULL_OR_EMPTY);
        }
        return Integer.parseInt(number);
    }

    private void validateAmountUnderZero(int amount) {
        if (amount < 0) {
            throw new LotteryGameException(ErrorCode.AMOUNT_UNDER_ZERO);
        }
    }

    public LotteryTickets createTickets(AutoGenerateStrategy autoGenerateStrategy) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lotteryTickets.add(autoGenerateStrategy.generate());
        }
        return new LotteryTickets(lotteryTickets);
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

    public Amount minus(Amount amount) {
        return new Amount(this.amount - amount.amount);
    }

    public int getAmount() {
        return amount;
    }
}
