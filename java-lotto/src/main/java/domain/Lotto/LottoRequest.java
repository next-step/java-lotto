package domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRequest {
    private final int manualTicketCount;
    private final List<List<Integer>> manualNumbers;

    public LottoRequest(int manualTicketCount, List<List<Integer>> manualNumbers) {
        this.manualTicketCount = manualTicketCount;
        this.manualNumbers = manualNumbers;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }

    public List<LottoTicket> toManualTickets() {
        return manualNumbers.stream()
                .map(numbers -> numbers.stream()
                        .map(LottoNo::new)
                        .collect(Collectors.toList()))
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}