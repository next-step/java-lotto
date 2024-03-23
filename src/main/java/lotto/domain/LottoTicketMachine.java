package lotto.domain;

import lotto.exception.IllegalPurchaseAmountException;

public class LottoTicketMachine {

    public static final int AMOUNT_PER_TICKET = 1000;

    public static LottoTickets issue(int amount) {
        int countOfTickets;
        try {
            countOfTickets = amount / AMOUNT_PER_TICKET;
        } catch (ArithmeticException e) {
            throw new IllegalPurchaseAmountException(amount);
        }

        return LottoTickets.auto(countOfTickets);
    }

}
