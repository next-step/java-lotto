package lotto.domains;

import lotto.enums.ErrorMessage;
import lotto.exceptions.CashOutOfBoundsException;
import lotto.exceptions.NumberOutOfBoundsException;
import lotto.tool.Converter;

public class Purchase {

    private static final int MIN_AMOUNT = 0;
    private static final int TICKET_PRICE = 1000;
    private static final int MIN_PURCHASE_PRICE = 1000;
    private static final int MAX_PURCHASE_PRICE = 1000000;
    private int cash;
    private int manualAmount;

    public Purchase(String text) {
        int cash = Converter.toInteger(text);

        if (cash < MIN_PURCHASE_PRICE || MAX_PURCHASE_PRICE < cash) {
            throw new CashOutOfBoundsException();
        }

        this.cash = cash;
    }

    public int ticketsAmount() {
        return this.cash / TICKET_PRICE;
    }

    public void selectManualAmount(int amount) {
        if (amount < MIN_AMOUNT || ticketsAmount() < amount) {
            throw new NumberOutOfBoundsException(ErrorMessage.MANUAL_AMOUNT_OUT_OF_BOUNDS.toString());
        }

        this.manualAmount = amount;
    }

    public boolean skipManualTickets() {
        return this.manualAmount == 0;
    }

    public boolean isNotSameAsManualAmount(Tickets tickets) {
        return tickets.size() != manualAmount;
    }

    public int automatedAmount() {
        return ticketsAmount() - manualAmount;
    }

}
