package lotto.utils;

import java.math.BigDecimal;

public class Tickets {

    private static final int TICKET_PRICE = 1000;

    public static int getNumberOfTickets(BigDecimal amount) {
        return amount.intValue() / TICKET_PRICE;
    }
}
