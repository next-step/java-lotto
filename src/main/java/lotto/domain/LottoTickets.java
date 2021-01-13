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
        List<LottoMatchResult> lottoMatchResults = groupingByPrizeWithWinnerLottoTicket(winnerLottoTicket);

        return lottoMatchResults.stream()
            .map(lottoMatchResult -> LottoPrizeType.of(lottoMatchResult.getMatchCount(), lottoMatchResult.hasBonusNumber()))
            .sorted()
            .collect(Collectors.groupingBy(lottoPrizeType -> lottoPrizeType, Collectors.counting()));
    }

    private List<LottoMatchResult> groupingByPrizeWithWinnerLottoTicket(WinnerLottoTicket winnerLottoTicket) {
        return this.list.stream()
            .map(winnerLottoTicket::getMatchResult)
            .collect(Collectors.toList());

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
