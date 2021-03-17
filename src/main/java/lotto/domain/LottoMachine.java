package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int buyAmount) {
        isBuyAmountValid(buyAmount);
        this.lottoTickets = createLottoTickets(buyAmount);
    }

    public LottoMachine(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < 1000) {
            throw new IllegalArgumentException(LottoConstant.BUY_AMOUNT_ERROR);
        }
    }

    private List<LottoTicket> createLottoTickets(int buyAmount) {
        int lottoQuantity = amountToQuantity(buyAmount);

        System.out.println(lottoQuantity + LottoConstant.BUY_QUANTITY_MESSAGE);

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
