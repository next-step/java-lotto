package step4.domain.lotto;

import step4.Constant;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.domain.lotto.firstcollection.LottoTickets;
import step4.strategy.NumberMakeStrategy;

import java.util.function.BiFunction;

import static step4.Constant.ERROR_INVALID_PARAMETER;
import static step4.Constant.ERROR_NOT_ENOUGH_MONEY;

public class LottoTicketMachine {
    private static final BiFunction<Long, Integer, Integer> division = (i, j) -> (int) (i / j);
    public static final int NOT_FOUND_INDEX = -1;

    private LottoTicketMachine() { }

    public static LottoTickets ticketing(LottoPurchaseInfoDTO infoDTO, NumberMakeStrategy strategy) {
        isValidPrice(infoDTO.getMoney());
        isValidCount(infoDTO.getManualSize());
        isEnoughMoney(infoDTO.getMoney(), infoDTO.getManualSize());
        return new LottoTickets(infoDTO, strategy);
    }

    public static int countAllowTicket(long inputPrice) {
        isValidPrice(inputPrice);
        return division.apply(inputPrice, Constant.LOTTO_PRICE);
    }

    public static int countAllowTicket(long money, int wantedTicketCount) {
        isValidCount(wantedTicketCount);
        isEnoughMoney(money, wantedTicketCount);
        return wantedTicketCount;
    }

    private static void isEnoughMoney(long money, int wantedTicketCount) {
        if (countAllowTicket(money) < wantedTicketCount) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
        }
    }

    private static void isValidPrice(double inputPrice) {
        if (inputPrice < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
        }
    }

    private static void isValidCount(int wantedTicketCount) {
        if (wantedTicketCount < 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PARAMETER);
        }
    }
}
