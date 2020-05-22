package lotto.domain.seller;

import lotto.domain.Price;
import lotto.domain.number.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoSeller of() {
        return new LottoSeller();
    }

    public List<LottoNumbers> buyTicket(final Price price) {
        validatePrice(price);

        List<LottoNumbers> tickets = new ArrayList<>();
        for (int i = 0; i < price.ticketCount(); i++) {
            tickets.add(LottoNumbers.auto());
        }
        return tickets;
    }

    private void validatePrice(final Price price) {
        price.validateAvailablePrice();
    }
}
