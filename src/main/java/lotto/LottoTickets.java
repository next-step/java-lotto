package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> ticketList;

    private LottoTickets(List<LottoTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public static LottoTickets createManualNewTickets(List<LottoTicket> ticketList) {
        return new LottoTickets(ticketList);
    }

    public static LottoTickets createNewTickets(int purchaseCount, List<LottoTicket> manualLottoTicketList) {
        List<LottoTicket> ticketList = new ArrayList<>();
        int autoTicketCount = purchaseCount - manualLottoTicketList.size();
        createAutoTicket(autoTicketCount, ticketList);
        createManualTicket(manualLottoTicketList, ticketList);

        return new LottoTickets(ticketList);
    }

    private static void createAutoTicket(int autoTicketCount, List<LottoTicket> ticketList) {
        for (int i = 0; i < autoTicketCount; i++) {
            ticketList.add(LottoTicket.createAutoNewTicket());
        }
    }

    private static void createManualTicket(List<LottoTicket> manualLottoTicketList, List<LottoTicket> ticketList) {
        if (manualLottoTicketList.size() > 0) {
            ticketList.addAll(manualLottoTicketList);
        }
    }


    public LottoTicket getLottoTicket(int index) {
        return ticketList.get(index);
    }

    public int size() {
        return ticketList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(ticketList, that.ticketList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketList);
    }
}
