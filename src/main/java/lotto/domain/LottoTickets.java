package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;
    private final Count manualTicketCount;
    private final Count autoTicketCount;

    public LottoTickets(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
        List<LottoTicket> totalTickets = new ArrayList<>();
        totalTickets.addAll(manualTickets);
        totalTickets.addAll(autoTickets);
        this.tickets = totalTickets;
        this.manualTicketCount = new Count(manualTickets.size());
        this.autoTicketCount = new Count(autoTickets.size());
    }

    private LottoTickets(List<LottoTicket> tickets, Count manualTicketCount, Count autoTicketCount) {
        this.tickets = tickets;
        this.manualTicketCount = manualTicketCount;
        this.autoTicketCount = autoTicketCount;
    }

    public static LottoTickets fromManualTickets(List<LottoTicket> tickets) {
        return new LottoTickets(tickets, new ArrayList<>());
    }

    public static LottoTickets fromAutoTickets(List<LottoTicket> tickets) {
        return new LottoTickets(new ArrayList<>(), tickets);
    }

    public LottoTickets add(LottoTickets other) {
        List<LottoTicket> totalTickets = new ArrayList<>();
        totalTickets.addAll(other.tickets);
        totalTickets.addAll(this.tickets);
        return new LottoTickets(totalTickets, Count.add(this.manualTicketCount, other.manualTicketCount),
            Count.add(this.autoTicketCount, other.autoTicketCount));
    }

    public Price getTotalPrice() {
        return Price.calculateFromTicketCount(tickets.size());
    }

    public Count getManualTicketCount() {
        return this.manualTicketCount;
    }

    public Count getAutoTicketCount() {
        return this.autoTicketCount;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
