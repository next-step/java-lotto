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

    //TODO: 본 생성자 지워야 하는지 확인 -> 서비스의 유연성을 위해 둬도 되지 않을까
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

    public LottoTickets(int ticketCount, List<List<Integer>> manualLottoTickets) {
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

    private List<LottoTicket> manualTickets(List<List<Integer>> manualLottoTickets) {
        return manualLottoTickets.stream()
                .map(LottoTicket::valueOf)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> autoTickets(int autoTicketCounts) {
        return IntStream.range(0, autoTicketCounts)
                .mapToObj(i -> new LottoTicket(new RandomNumbers().lottoNumbers()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> value() {
        return tickets;
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
