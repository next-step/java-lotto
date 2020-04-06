package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;
    private static final Map<LottoPrize, Integer> lottoResult = new HashMap<>();

    static {
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize ->
                        lottoResult.put(lottoPrize, ZERO)
                );
    }

    public LottoResult() {
    }

    public LottoResult(LottoTicket winningTicket, LottoTickets myTickets) {
        for (LottoTicket ticket : myTickets.ticketList()) {
            int matched = ticket.findMatchCount(winningTicket);
            increase(LottoPrize.find(matched, ticket.hasBonusNumber(winningTicket)));
        }
    }

    public int prizeCount(LottoPrize prize) {
        return lottoResult.get(prize);
    }

    public double average() {
        return totalPrice() / totalTicketCost();
    }

    public void increase(LottoPrize prize) {
        lottoResult.put(prize, lottoResult.get(prize) + 1);
    }

    private double totalPrice() {
        int sum = ZERO;
        for (LottoPrize prize : LottoPrize.values()) {
            sum += prize.getPrice() * lottoResult.get(prize);
        }
        return sum;
    }

    private double totalTicketCost() {
        int totalTicketCount = ZERO;
        for (int ticketCount : lottoResult.values()) {
            totalTicketCount += ticketCount;
        }
        return totalTicketCount * TICKET_PRICE;
    }
}
