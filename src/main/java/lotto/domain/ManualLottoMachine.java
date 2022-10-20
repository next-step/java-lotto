package lotto.domain;

import lotto.domain.exception.InvalidManualLottoPurchasePriceException;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.MarkingPaper;
import lotto.domain.number.Ticket;

public class ManualLottoMachine implements LottoMachine {

    private final MarkingPaper markingPaper = new MarkingPaper();

    @Override
    public TicketBox issueTickets(PurchasePrice purchasePrice) {
        int count = getTicketCount(purchasePrice, Ticket.getPrice());
        if (markingPaper.getMarkingSize() != count) {
            throw new InvalidManualLottoPurchasePriceException(Ticket.getPrice());
        }

        TicketBox ticketBox = new TicketBox(markingPaper.convertPapersToTickets());
        markingPaper.clear();

        return ticketBox;
    }

    public void markLottoBalls(LottoBalls lottoBalls) {
        markingPaper.markLottoBalls(lottoBalls);
    }
}
