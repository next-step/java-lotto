package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매하셨습니다.";

    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int buyAmount) {
        isBuyAmountValid(buyAmount);
        this.lottoTickets = createLottoTickets(buyAmount);
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < 1000) {
            throw new IllegalArgumentException(BUY_AMOUNT_ERROR);
        }
    }

    private List<LottoTicket> createLottoTickets(int buyAmount) {
        int lottoQuantity = amountToQuantity(buyAmount);

        System.out.println(lottoQuantity + BUY_QUANTITY_MESSAGE);

        List<LottoTicket> tickets = new ArrayList<>();
        for(int i = 0; i < lottoQuantity; i++) {
            tickets.add(new LottoTicket());
        }

        return tickets;
    }

    private int amountToQuantity(int amount) {
        return amount / 1000;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
