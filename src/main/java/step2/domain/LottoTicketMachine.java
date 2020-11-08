package step2.domain;

import step2.Constant;
import step2.strategy.NumberMakeStrategy;

import java.util.function.IntBinaryOperator;

public class LottoTicketMachine {
    private final IntBinaryOperator division = (i, j)-> i / j;

    public LottoTickets ticketing(int inputPrice, NumberMakeStrategy strategy) {
        int count = countAllowTicket(inputPrice);
        return new LottoTickets(count, strategy);
    }

    public int countAllowTicket(int inputPrice) {
        isValidPrice(inputPrice);
        return division.applyAsInt(inputPrice, Constant.LOTTO_PRICE);
    }

    private void isValidPrice(int inputPrice) {
        if (inputPrice < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_ENOUGH_MONEY);
        }
    }
}
