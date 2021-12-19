package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTickets {

    private static final String EXCEPTION_MESSAGE_PARAMETER_CAN_NOT_BE_NULL = "파라미터가 null 일 수 없습니다.";

    private final List<LotteryTicket> tickets;

    private LotteryTickets(final List<LotteryTicket> tickets) {
        this.tickets = tickets;
    }

    public static LotteryTickets create() {
        return new LotteryTickets(Collections.emptyList());
    }

    public static LotteryTickets create(final List<LotteryTicket> tickets) {
        return new LotteryTickets(tickets);
    }

    public static LotteryTickets create(final LotteryTickets manualLotteryTickets,
        final LotteryTickets autoLotteryTickets) {

        if (Objects.isNull(manualLotteryTickets) || Objects.isNull(autoLotteryTickets)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PARAMETER_CAN_NOT_BE_NULL);
        }

        final List<LotteryTicket> combinedTickets = Stream.concat(manualLotteryTickets.tickets.stream(),
                autoLotteryTickets.tickets.stream())
            .collect(Collectors.toList());
        return LotteryTickets.create(combinedTickets);
    }

    public List<LotteryTicket> tickets() {
        return Collections.unmodifiableList(tickets);
    }

    public LotteryResult result(final PurchasePrice purchasePrice, final WinningLotteryNumbers winningLotteryNumbers) {
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
