package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final int PRICE_PER_TICKET = 1000;
    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int MAXIMUM_PURCHASE_AMOUNT = 100000;

    private int purchaseAmount;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int amount) throws IllegalArgumentException {
        checkValidInput(amount);
        checkDividable(amount);
        this.purchaseAmount = amount;
        this.lottoTickets = issueTickets(purchaseAmount / PRICE_PER_TICKET);
    }

    private List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = LottoTicketGenerator.start().extract();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult(purchaseAmount);
        for (LottoTicket ticket : lottoTickets) {
            MatchStatus status = ticket.matchingStatusWith(winningNumbers);
            lottoResult.updateValue(status);
        }
        return lottoResult;
    }

    private void checkValidInput(int amount) throws IllegalArgumentException {
        if (amount < MINIMUM_PURCHASE_AMOUNT
                || amount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDividable(int amount) throws IllegalArgumentException {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException();
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
