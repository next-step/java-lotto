package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매하셨습니다.";
    private static final int MIN_BUY_AMOUNT = 1000;

    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int buyAmount) {
        isBuyAmountValid(buyAmount);
        this.lottoTickets = createLottoTickets(buyAmount);
    }

    public LottoMachine(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException(BUY_AMOUNT_ERROR);
        }
    }

    private List<LottoTicket> createLottoTickets(int buyAmount) {
        int lottoQuantity = amountToQuantity(buyAmount);

        System.out.println(lottoQuantity + BUY_QUANTITY_MESSAGE);

        List<LottoTicket> tickets = new ArrayList<>();

        IntStream.range(0, lottoQuantity)
                .forEach(i -> tickets.add(new LottoTicket()));

        return tickets;
    }

    private int amountToQuantity(int amount) {
        return amount / MIN_BUY_AMOUNT;
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
