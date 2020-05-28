package lotto.domain.price;

import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;
import lotto.exception.ErrorMessage;

import java.util.List;

public class PayInfo {

    private final Price price;
    private final LottoTickets manualTickets;
    private final List<List<LottoNumber>> manualTicketNumbers;

    private PayInfo(final Price price, final LottoTickets manualTickets) {
        validatePrice(price);
        verifyAvailableCount(price, manualTickets.count());

        this.price = price;
        this.manualTickets = manualTickets;
        this.manualTicketNumbers = null;
    }

    private PayInfo(final Price price, final List<List<LottoNumber>> manualTicketNumbers) {
        validatePrice(price);
        verifyAvailableCount(price, manualTicketNumbers.size());

        this.price = price;
        this.manualTickets = null;
        this.manualTicketNumbers = manualTicketNumbers;
    }

    public static PayInfo valueOf(final Price price, final LottoTickets manualTickets) {
        return new PayInfo(price, manualTickets);
    }

    public static PayInfo valueOf(final Price price, final List<List<LottoNumber>> manualTicketNumbers) {
        return new PayInfo(price, manualTicketNumbers);
    }

    private static void validatePrice(final Price price) {
        if (price == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    private static void verifyAvailableCount(final Price price, final int manualTicketCount) {
        if (price.isExceedCount(manualTicketCount)) {
            throw new AvailableCountExceedException();
        }
    }

    public int getManualTicketsCount() {
        return manualTickets.count();
    }

    public int getAutoTicketsCount() {
        return price.getTicketCount() - getManualTicketsCount();
    }

    public LottoTickets getManualTickets() {
        return manualTickets;
    }
}
