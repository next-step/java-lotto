package lotto.view;

import lotto.exception.InvalidMoneyUnitException;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.Money;
import lotto.util.InputUtil;

import java.util.List;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.";

    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final String INPUT_MANUAL_LOTTO_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

    private static final long PRICE_PER_TICKET = 1_000L;

    public Money readMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        long value = InputUtil.readLongNumber();
        validateMoneyUnit(value);
        return new Money(value);
    }

    private void validateMoneyUnit(long value) {
        if (!meetsMoneyUnit(value)) {
            throw new InvalidMoneyUnitException(value);
        }
    }

    private boolean meetsMoneyUnit(long value) {
        return value % PRICE_PER_TICKET == 0;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return InputUtil.readNumbers();
    }

    public LottoNumber readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return LottoNumber.create(InputUtil.readIntNumber());
    }

    public Money readManualTicketPrice() {
        System.out.println(INPUT_MANUAL_LOTTO_TICKET_COUNT);
        int ticketCount = InputUtil.readIntNumber();
        return new Money(ticketCount * PRICE_PER_TICKET);
    }
}
