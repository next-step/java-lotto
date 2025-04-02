package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;
    private final int autoTicketCount;

    public LottoTickets(int money, List<LottoTicket> manualTickets) {
        int autoTicketCount = money / LottoTicket.PRICE - manualTickets.size();
        validateAutoTicketCount(autoTicketCount);
        this.lottoTickets = Stream.concat(manualTickets.stream(), generateLottoTickets(autoTicketCount).stream())
                .collect(Collectors.toList());
        this.autoTicketCount = autoTicketCount;
    }

    private void validateAutoTicketCount(int autoTicketCount) {
        if (autoTicketCount < 0) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
    }

    private List<LottoTicket> generateLottoTickets(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public int getLottoTicketCount() {
        return this.lottoTickets.size();
    }

    public int getAutoTicketCount() {
        return this.autoTicketCount;
    }

    public int getManualTicketCount() {
        return getLottoTicketCount() - getAutoTicketCount();
    }
}
