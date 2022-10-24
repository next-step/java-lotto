package lotto.domain.lottomachine;

import java.util.Optional;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.exception.InvalidManualLottoPurchasePriceException;
import lotto.domain.exception.NullMarkingPaperException;
import lotto.domain.number.MarkingPaper;
import lotto.domain.number.Ticket;

public class ManualLottoMachine implements LottoMachine {

    private final MarkingPaper markingPaper;

    public ManualLottoMachine(MarkingPaper markingPaper) {
        this.markingPaper = Optional.ofNullable(markingPaper)
                .orElseThrow(NullMarkingPaperException::new);
    }

    @Override
    public TicketBox issueTickets(PurchasePrice purchasePrice) {
        int count = getTicketCount(purchasePrice, Ticket.getPrice());
        if (markingPaper.getMarkingSize() != count) {
            throw new InvalidManualLottoPurchasePriceException(Ticket.getPrice());
        }

        return new TicketBox(markingPaper.convertPapersToTickets());
    }

}
