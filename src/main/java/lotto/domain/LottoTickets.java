package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> list;

    public LottoTickets(List<LottoTicket> list) {
        this.list = list;
    }

    public Map<LottoPrizeType, Long> checkResult(WinnerLottoTicket winnerLottoTicket) {
        return groupingByPrizeWithWinnerLottoTicket(winnerLottoTicket);
    }

    private Map<LottoPrizeType, Long> groupingByPrizeWithWinnerLottoTicket(WinnerLottoTicket winnerLottoTicket) {
        return this.list.stream()
            .map(winnerLottoTicket::getMatchResult)
            .sorted()
            .collect(Collectors.groupingBy(lottoPrizeType -> lottoPrizeType, Collectors.counting()))
            ;

    }

    public int size() {
        return this.list.size();
    }

    public List<String> getLottoTicketString() {
        return this.list.stream()
            .map(LottoTicket::joiningResult)
            .collect(Collectors.toList());
    }
}
