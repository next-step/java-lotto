package lottery.domain;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoTicketCount {

    private static final String EXCEPTION_MESSAGE_INSUFFICIENT_AUTO_TICKET_COUNT = "자동 구매는 0장 이상 이어야 합니다.";
    private static final int MINIMUM_AUTO_TICKET_COUNT = 0;

    private final int value;

    private AutoTicketCount(final int value) {
        this.value = value;
    }

    public static AutoTicketCount from(final int count) {
        if (count < MINIMUM_AUTO_TICKET_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INSUFFICIENT_AUTO_TICKET_COUNT);
        }

        return new AutoTicketCount(count);
    }

    public int getValue() {
        return value;
    }

    public LotteryTickets buyTickets(final LotteryNumberGenerator lotteryNumberGenerator) {
        return IntStream.range(0, value)
            .mapToObj(idx -> LotteryTicket.from(lotteryNumberGenerator))
            .collect(Collectors.collectingAndThen(Collectors.toList(), LotteryTickets::create));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AutoTicketCount that = (AutoTicketCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
