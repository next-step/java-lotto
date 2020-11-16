package step4.lotto;

import step4.Constant;
import step4.lotto.firstcollection.LottoTickets;
import step4.strategy.NumberMakeStrategy;

import java.util.function.BiFunction;

public class LottoTicketMachine {

    private static final BiFunction<Long, Integer, Integer> division = (i, j) -> (int) (i / j);
    public static final int NOT_FOUND_INDEX = -1;

    private LottoTicketMachine() { }

    public static LottoTickets ticketing(int inputPrice, NumberMakeStrategy strategy) {
        int count = countAllowTicket(inputPrice);
        return new LottoTickets(count, strategy);
    }

    public static int countAllowTicket(long inputPrice) {
        isValidPrice(inputPrice);
        return division.apply(inputPrice, Constant.LOTTO_PRICE);
    }

    public static int countAllowManualTicket(long money, int wantedTicketCount) {
        isValidCount(wantedTicketCount);
        if (countAllowTicket(money) < wantedTicketCount) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_ENOUGH_MONEY);
        }
        return wantedTicketCount;
    }

    private static void isValidPrice(double inputPrice) {
        if (inputPrice < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_ENOUGH_MONEY);
        }
    }

    private static void isValidCount(int wantedTicketCount) {
        if (wantedTicketCount < 0) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_PARAMETER);
        }
    }
}
