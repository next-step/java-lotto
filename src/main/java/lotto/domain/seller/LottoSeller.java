package lotto.domain.seller;

import lotto.domain.number.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    static final int ONE_TICKET_PRICE = 1000;

    private LottoSeller() {
    }

    public static LottoSeller of() {
        return new LottoSeller();
    }

    public List<LottoNumbers> buyTicket(final int money) {
        validateMoney(money);
        int countTicket = money / ONE_TICKET_PRICE;

        List<LottoNumbers> tickets = new ArrayList<>();
        for (int i = 0; i < countTicket; i++) {
            tickets.add(LottoNumbers.auto());
        }
        return tickets;
    }

    private void validateMoney(final int money) {
        if (money < ONE_TICKET_PRICE) {
            throw new IllegalArgumentException("최소 금액 " + ONE_TICKET_PRICE + "원이 필요합니다.");
        }
    }
}
