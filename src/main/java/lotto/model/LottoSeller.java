package lotto.model;

import java.util.List;

public class LottoSeller {
    private static final int TICKET_PRICE = 1000;
    private static final String ERR_VALID_MANUAL_COUNT = "Manual tickets cannot exceed %d, which is the total number of tickets.";

    public static int calculateTicketCount(int money) {
        return money/TICKET_PRICE;
    }

    public static int price(int count) {
        return count * TICKET_PRICE;
    }

    public static Lottos issueLotto(int money, List<List<Integer>> manualTicketsNumbers) {
        int ticketCount = calculateTicketCount(money);
        validateTicketCount(ticketCount, manualTicketsNumbers.size());

        Lottos manual = Lottos.generate(manualTicketsNumbers);
        Lottos auto = Lottos.generate(ticketCount-manualTicketsNumbers.size());
        return Lottos.combine(manual, auto);
    }

    private static void validateTicketCount(int totalCount, int manualCount) {
        if (totalCount < manualCount) {
            throw new IllegalArgumentException(String.format(ERR_VALID_MANUAL_COUNT, totalCount));
        }
    }
}
