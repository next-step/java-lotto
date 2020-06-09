package step2.model;

import step2.exception.NotEnoughMoneyException;

import java.util.List;

public class LottoMachine {

    private static final int MIN_TICKET_COUNT = 1;

    private final LottoTicketPrice ticketPrice;

    private LottoMachine(LottoTicketPrice ticketPrice) {
        if (ticketPrice == null) {
            throw new IllegalArgumentException("티켓 금액을 입력해주세요.");
        }

        this.ticketPrice = ticketPrice;
    }

    public static LottoMachine create(LottoTicketPrice ticketPrice) {
        return new LottoMachine(ticketPrice);
    }

    public LottoTicket buyTicket(MoneyAmount moneyAmount, List<Lotto> manualLottos) {
        int availableCount = ticketPrice.getAvailablePurchase(moneyAmount);

        int manualCount = manualLottos.size();
        int autoCount = availableCount - manualCount;

        if (isLessThanMinCount(availableCount)
                || isOverManualLottos(availableCount, manualCount)) {
            throw new NotEnoughMoneyException();
        }

        moneyAmount.useAmount(ticketPrice.calculatePurchaseAmount(availableCount));

        return LottoTicketGenerator.generate(autoCount, manualLottos);
    }

    private boolean isOverManualLottos(int availableCount, int manualCount) {
        return availableCount < manualCount;
    }

    private boolean isLessThanMinCount(int availableCount) {
        return availableCount < MIN_TICKET_COUNT;
    }
}
