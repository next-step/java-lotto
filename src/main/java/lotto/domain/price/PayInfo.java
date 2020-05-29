package lotto.domain.price;

import lotto.domain.number.LottoNumber;
import lotto.exception.AvailableCountExceedException;
import lotto.exception.ErrorMessage;

import java.util.List;

public class PayInfo {

    private final Price price;
    private final List<List<LottoNumber>> manualTicketNumbers;

    private PayInfo(final Price price, final List<List<LottoNumber>> manualTicketNumbers) {
        validatePrice(price);
        verifyAvailableCount(price, manualTicketNumbers.size());

        this.price = price;
        this.manualTicketNumbers = manualTicketNumbers;
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

    public int getAvailableAutoTicketsCount() {
        return price.getTicketCount() - getManualTicketCount();
    }

    private int getManualTicketCount() {
        return this.manualTicketNumbers.size();
    }

    public List<List<LottoNumber>> getManualTicketNumbers() {
        return manualTicketNumbers;
    }
}
