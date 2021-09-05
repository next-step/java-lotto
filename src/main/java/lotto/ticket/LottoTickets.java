package lotto.ticket;

import lotto.number.RandomNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    public static final int TICKET_COUNT_MIN = 1;
    private final List<LottoTicket> tickets;

    public LottoTickets(int[][] numbers) {
        this(Arrays.stream(numbers)
                .map(LottoTicket::new)
                .collect(Collectors.toList()));
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoTickets(int ticketCount) {
        isValid(ticketCount);
        this.tickets = autoTickets(ticketCount);
    }

    private void isValid(int ticketCount) {
        if (ticketCount < TICKET_COUNT_MIN) {
            throw new IllegalArgumentException("티켓 수는 양수입니다.");
        }
    }

    public LottoTickets(int ticketCount, List<LottoTicket> manualLottoTickets) {
        List<LottoTicket> manualTickets = manualTickets(manualLottoTickets);
        List<LottoTicket> autoTickets = autoTickets(ticketCount - manualTickets.size());
        this.tickets = combinedTickets(autoTickets, manualTickets);
    }

    private List<LottoTicket> combinedTickets(List<LottoTicket> autos, List<LottoTicket> manuals) {
        List<LottoTicket> combined = new ArrayList<>();
        combined.addAll(autos);
        combined.addAll(manuals);
        return combined;
    }

    private List<LottoTicket> manualTickets(List<LottoTicket> manualLottoTickets) {
        return manualLottoTickets.stream()
                .map(ticket -> new LottoTicket(ticket.lottoNumbers(), TicketType.MANUAL))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> autoTickets(int autoTicketCounts) {
        RandomNumbers randomNumbers = new RandomNumbers();

        return IntStream.range(0, autoTicketCounts)
                .mapToObj(i -> new LottoTicket(randomNumbers.lottoNumbers(), TicketType.AUTO))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> value() {
        return tickets;
    }

    public int autoTicketCount() {
        return (int) tickets.stream()
                .filter(LottoTicket::isAuto)
                .count();
    }

    public int manualTicketCount() {
        return (int) tickets.stream()
                .filter(LottoTicket::isManual)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
