package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    public static final int LOTTO_TICKET_SIZE = 6;
    private final List<Integer> ticket;

    private LottoTicket(List<Integer> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket newTicket(List<Integer> ticket) {
        validate(ticket);
        return new LottoTicket(ticket);
    }

    private static void validate(List<Integer> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }

        Set<Integer> ticketSet = new HashSet<>(ticket);
        if (ticketSet.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        for (Integer integer : ticket) {
            validateMinAndMax(integer);
        }
    }

    private static void validateMinAndMax(Integer integer) {
        if (integer > LottoTotalNumberUtils.LOTTO_NUMBER_MAXIMUM) {
            throw new IllegalArgumentException("로또 번호는 45보다 클 수 없습니다.");
        }

        if (integer < LottoTotalNumberUtils.LOTTO_NUMBER_MINIMUM) {
            throw new IllegalArgumentException("로또 번호는 1보다 작을 수 없습니다.");
        }
    }

    public List<Integer> getTicket() {
        return Collections.unmodifiableList(ticket);
    }

    public int size() {
        return ticket.size();
    }
}
