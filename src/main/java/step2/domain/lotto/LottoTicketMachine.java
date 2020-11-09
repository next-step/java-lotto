package step2.domain.lotto;

import step2.Constant;
import step2.strategy.NumberMakeStrategy;

import java.util.function.BiFunction;

public class LottoTicketMachine {

    private final BiFunction<Double, Integer, Integer> division = (i, j) -> (int) (i / j);

    public LottoTickets ticketing(int inputPrice, NumberMakeStrategy strategy) {
        int count = countAllowTicket(inputPrice);
        return new LottoTickets(count, strategy);
    }

    public int countAllowTicket(double inputPrice) {
        isValidPrice(inputPrice);
        return division.apply(inputPrice, Constant.LOTTO_PRICE);
    }

    private void isValidPrice(double inputPrice) {
        if (inputPrice < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_ENOUGH_MONEY);
        }
    }
}
