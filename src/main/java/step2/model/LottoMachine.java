package step2.model;

import step2.exception.NotEnoughMoneyException;

public class LottoMachine {

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

    public LottoTicket buyTicket(MoneyAmount moneyAmount, ManualLottoNumbers manualLottoNumbers) {
        LottoCount lottoCount = ticketPrice.calculatePurchaseCount(moneyAmount);

        if (lottoCount.isOverManualCount(manualLottoNumbers)) {
            throw new NotEnoughMoneyException();
        }

        moneyAmount.useAmount(ticketPrice.calculatePurchaseAmount(lottoCount));

        return LottoTicketGenerator.generate(lottoCount, manualLottoNumbers);
    }
}
