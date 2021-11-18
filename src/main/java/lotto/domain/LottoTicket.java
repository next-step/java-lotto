package lotto.domain;

import java.util.Objects;
import java.util.Set;
import lotto.exception.ArgumentCountException;
import lotto.exception.ArgumentNumberException;

public class LottoTicket {

    private static final Integer TICKET_NUMBER_COUNT = 6;
    private static final Integer TICKET_MINIMUM_NUMBER = 1;
    private static final Integer TICKET_MAXIMUM_NUMBER = 45;
    private static final Integer TICKET_NUMBER_ALLOWED_COUNT = 0;

    private final Set<Integer> ticket;

    private LottoTicket(Set<Integer> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket of(Set<Integer> args) {
        valid(args);
        return new LottoTicket(args);
    }

    private static void valid(Set<Integer> args) {
        validArgumentCount(args);
        validArgumentNumber(args);
    }

    private static void validArgumentCount(Set<Integer> args) {
        if (args == null || args.isEmpty() || args.size() != TICKET_NUMBER_COUNT) {
            throw new ArgumentCountException(TICKET_NUMBER_COUNT);
        }
    }

    private static void validArgumentNumber(Set<Integer> args) {
        long count = args.stream()
            .filter(LottoTicket::isNumberSize)
            .count();

        if (count > TICKET_NUMBER_ALLOWED_COUNT) {
            throw new ArgumentNumberException(TICKET_MINIMUM_NUMBER, TICKET_MAXIMUM_NUMBER);
        }
    }

    private static boolean isNumberSize(Integer number) {
        return TICKET_MINIMUM_NUMBER > number || number > TICKET_MAXIMUM_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
