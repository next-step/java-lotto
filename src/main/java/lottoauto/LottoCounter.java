package lottoauto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoCounter {
    private final int manualCount;
    private final int autoCount;


    public LottoCounter(Money money, int manualCount) {
        int totalCount = money.calcLottoCount(LottoTicket.LOTTO_TICKET_PRICE);

        if(totalCount < manualCount) {
            throw new IllegalArgumentException("돈이 부족하여 수동티켓을 줄 수 없습니다.");
        }
        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
    }

    public int manualCount() {
        return manualCount;
    }

    public int autoCount() {
        return autoCount;
    }

    public LottoTickets generateLottoTickets(List<String> manualTicketNumbers) {
        LottoTickets lottoTickets = new LottoTickets(autoCount, new AutoStrategy());
        lottoTickets.addFirst(manualTicketNumbers.stream()
                .map(s -> new LottoTicket(new ManualStrategy(s)))
                .collect(Collectors.toList()));

        return lottoTickets;
    }
}
