package step3.domain.lotto;

import step3.Constant;
import step3.domain.lotto.firstcollection.LottoTickets;
import step3.strategy.NumberMakeStrategy;

import java.util.function.BiFunction;

public class LottoTicketMachine {

    private static final BiFunction<Double, Integer, Integer> division = (i, j) -> (int) (i / j);

    private LottoTicketMachine() { }

    public static LottoTickets ticketing(int inputPrice, NumberMakeStrategy strategy) {
        int count = countAllowTicket(inputPrice);
        return new LottoTickets(count, strategy);
    }

    public static int countAllowTicket(double inputPrice) {
        isValidPrice(inputPrice);
        return division.apply(inputPrice, Constant.LOTTO_PRICE);
    }

    private static void isValidPrice(double inputPrice) {
        if (inputPrice < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_ENOUGH_MONEY);
        }
    }
}
