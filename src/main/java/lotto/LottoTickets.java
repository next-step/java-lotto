package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {

    private LottoTicket[] lottoTickets;

    public LottoTickets(int money, int manualCount) {
        int ticketCount = money / LottoTicket.TICKET_PRICE;
        if (ticketCount < manualCount) {
            throw new IllegalArgumentException("구매 가능한 티켓 수는 " + ticketCount + "개 입니다.");
        }
        lottoTickets = Stream.concat(
                buyManualTickets(manualCount).stream(),
                buyAutoTickets(ticketCount - manualCount).stream()
        ).toArray(LottoTicket[]::new);
    }

    public int getManualTicketCount() {
        return (int) Arrays.stream(lottoTickets).filter(LottoTicket::isManual).count();
    }

    public int getAutoTicketCount() {
        return (int) Arrays.stream(lottoTickets).filter(LottoTicket::isAuto).count();
    }

    private List<LottoTicket> buyAutoTickets(int count) {
        return buyTickets(count, false);
    }

    private List<LottoTicket> buyManualTickets(int manualCount) {
        return buyTickets(manualCount, true);
    }

    private List<LottoTicket> buyTickets(int ticketCount, boolean isManual) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new LottoTicket(isManual))
                .collect(Collectors.toList());
    }

}
