package lotto.domains;

import lotto.enums.ErrorMessage;
import lotto.exceptions.CashOutOfBoundsException;
import lotto.tool.Converter;

public class Purchase {

    private static final int TICKET_PRICE = 1000;
    private static final int MIN_PURCHASE_PRICE = 1000;
    private static final int MAX_PURCHASE_PRICE = 1000000;
    private int cash;

    public Purchase(String text) {
        int cash = Converter.toInteger(text);

        if (cash < MIN_PURCHASE_PRICE || MAX_PURCHASE_PRICE < cash) {
            throw new CashOutOfBoundsException(ErrorMessage.CASH_OUT_OF_BOUNDS.toString());
        }

        this.cash = cash;
    }

    public int ticketsAmount() {
        return this.cash / TICKET_PRICE;
    }

    public int payment() {
        return ticketsAmount() * TICKET_PRICE;
    }

}
