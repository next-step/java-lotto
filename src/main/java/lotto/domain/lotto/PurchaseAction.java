package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.LottoAutoGenerator;

public class PurchaseAction {

    private static final int PRICE_PER_ONE_TICKET = 1000;
    private static final String EXCEPTION_AMOUNT_RANGE = "1000원 이상의 금액을 입력해주세요";

    private final int amount;
    private final int count;

    public PurchaseAction(int amount) {
        validateAmount(amount);
        this.amount = amount;
        this.count = this.amount/PRICE_PER_ONE_TICKET;
    }

    public Tickets purchase() {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = new Ticket(new LottoAutoGenerator().generateNumbers());
            tickets.add(ticket);
        }

        return new Tickets(tickets);
    }

    private void validateAmount(int amount) {
        if (amount <= 1000) {
            throw new IllegalArgumentException(EXCEPTION_AMOUNT_RANGE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}
