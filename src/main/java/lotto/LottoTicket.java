package lotto;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_TICKET_SIZE = 6;
    private final List<Number> ticket;

    private LottoTicket(List<Number> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket createManualNewTicket(List<Number> ticket) {
        validate(ticket);

        return new LottoTicket(ticket);
    }

    public static LottoTicket createAutoNewTicket() {
        List<Number> ticket = createTicketNumber();
        validate(ticket);

        Collections.sort(ticket);

        return new LottoTicket(ticket);
    }

    private static List<Number> createTicketNumber() {
        List<Number> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();

        List<Number> ticket = new ArrayList<>();
        for (int i = 0; i < LottoTicket.LOTTO_TICKET_SIZE; i++) {
            ticket.add(lottoTotalNumbers.get(i));
        }

        return ticket;
    }

    private static void validate(List<Number> ticket) {
        if (ticket.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_TICKET_SIZE + "개이어야 합니다.");
        }

        Set<Number> ticketSet = new HashSet<>(ticket);
        if (ticketSet.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public int calculateCountOfMatch(List<Number> ticketNumbers) {
        int countOfMatch = 0;

        for (Number winningNumber : ticket) {
            countOfMatch = contains(ticketNumbers, countOfMatch, winningNumber);
        }

        return countOfMatch;
    }

    private int contains(List<Number> ticketNumbers, int countOfMatch, Number winningNumber) {
        if (ticketNumbers.contains(winningNumber)) {
            countOfMatch++;
        }

        return countOfMatch;
    }

    public List<Number> getTicket() {
        return Collections.unmodifiableList(ticket);
    }

    public int size() {
        return ticket.size();
    }
}
