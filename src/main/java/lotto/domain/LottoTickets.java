package lotto.domain;

import lotto.exception.CustomIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final int PRICE_PER_TICKET = 1000;
    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int MAXIMUM_PURCHASE_AMOUNT = 100000;

    private int purchaseAmount;
    private final List<LottoTicket> lottoTickets;
    private final TicketGenerator ticketGenerator;

    public LottoTickets(TicketGenerator ticketGenerator, int amount) throws CustomIllegalArgumentException {
        checkValidInput(amount);
        checkDividable(amount);
        this.ticketGenerator = ticketGenerator;
        this.purchaseAmount = amount;
        this.lottoTickets = issueTickets(purchaseAmount / PRICE_PER_TICKET);
    }

    private List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = ticketGenerator.extract();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        return new LottoResult(purchaseAmount, winningNumbers, lottoTickets);
    }

    private void checkValidInput(int amount) throws CustomIllegalArgumentException {
        if (amount < MINIMUM_PURCHASE_AMOUNT
                || amount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_AMOUNT_OUT_OF_RANGE,
                    MINIMUM_PURCHASE_AMOUNT,
                    MAXIMUM_PURCHASE_AMOUNT);
        }
    }

    private void checkDividable(int amount) throws CustomIllegalArgumentException {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new CustomIllegalArgumentException(Message.ERROR_AMOUNT_CANNOT_BE_DIVIDED,
                    PRICE_PER_TICKET);
        }
    }

    public int count() {
        return lottoTickets.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : lottoTickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
