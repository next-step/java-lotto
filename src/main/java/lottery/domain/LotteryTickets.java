package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LotteryTickets {

    private static final String EXCEPTION_MESSAGE_GENERATOR_CAN_NOT_BE_NULL = "로또 번호 생성기가 null일 수 없습니다.";

    private final PurchasePrice purchasePrice;
    private final List<LotteryTicket> tickets;

    private LotteryTickets(final PurchasePrice purchasePrice, final List<LotteryTicket> tickets) {
        this.purchasePrice = purchasePrice;
        this.tickets = tickets;
    }

    public static LotteryTickets create(final PurchasePrice purchasePrice, final List<LotteryTicket> tickets) {
        return new LotteryTickets(purchasePrice, tickets);
    }

    public static LotteryTickets create(final PurchasePrice purchasePrice, final LotteryNumberGenerator lotteryNumberGenerator) {
        final int ticketCount = purchasePrice.affordableTicketCount();
        if (Objects.isNull(lotteryNumberGenerator)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_GENERATOR_CAN_NOT_BE_NULL);
        }

        final List<LotteryTicket> tickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(LotteryTicket.from(lotteryNumberGenerator));
        }

        return new LotteryTickets(purchasePrice, tickets);
    }

    public List<LotteryTicket> tickets() {
        return Collections.unmodifiableList(tickets);
    }

    public LotteryResult result(final WinningLotteryNumbers winningLotteryNumbers) {
        return LotteryResult.of(purchasePrice, winningLotteryNumbers, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryTickets that = (LotteryTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
