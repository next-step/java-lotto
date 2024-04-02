package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<WinningInfo, Long> lottoResult;

    public Long countMatch(WinningInfo winningInfo) {
        return lottoResult.getOrDefault(winningInfo, 0L);
    }

    public LottoResult(List<LottoTicket> lottoTickets, LottoTicket lastWeekLotto) {
        lottoResult = lottoTickets.stream()
                .map(ticket -> ticket.getNumberOfMatch(lastWeekLotto))
                .collect(Collectors.groupingBy(
                                matchCount -> WinningInfo.from(matchCount),
                                Collectors.counting()
                        )
                );
    }

    public double calculateProfitRatio(long totalEarnings, long purchaseAmount){
        return  (double) totalEarnings / purchaseAmount;
    }

}
