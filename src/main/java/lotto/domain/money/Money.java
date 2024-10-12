package lotto.domain.money;

import lotto.exception.InvalidMoneyAmountException;

public class Money {

    private final long amount;

    private Money(long amount) {
        checkIfNegativeAmount(amount);
        this.amount = amount;
    }

    private static void checkIfNegativeAmount(long amount) {
        if (isLessThanZero(amount)) {
            throw new InvalidMoneyAmountException("구입금액은 양수여야 합니다.");
        }
    }

    private static boolean isLessThanZero(long amount) {
        return amount < 0;
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public long getAmount() {
        return amount;
    }

    public int availableLottoTickets(long lottoTicketPrice) {
        checkIfAmountIsLessThanLottoTicketPrice(lottoTicketPrice);
        return (int) (amount / lottoTicketPrice);
    }

    private void checkIfAmountIsLessThanLottoTicketPrice(long lottoTicketPrice) {
        if (isAmountLessThanLottoTicketPrice(lottoTicketPrice)) {
            throw new InvalidMoneyAmountException("구입금액이 로또 티켓 1개 가격보다 작습니다.");
        }
    }

    private boolean isAmountLessThanLottoTicketPrice(long lottoTicketPrice) {
        return amount < lottoTicketPrice;
    }
}
