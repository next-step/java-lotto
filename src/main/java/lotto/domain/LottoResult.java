package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<WinningInfo, Long> lottoResult;

    public Long countMatch(WinningInfo winningInfo) {
        return lottoResult.getOrDefault(winningInfo, 0L);
    }

    public LottoResult(List<LottoTicket> lottoTickets, List<Integer> lastWeekLottoNumber) {
        lottoResult = lottoTickets.stream()
                .map(ticket -> ticket.getNumberOfMatch(lastWeekLottoNumber))
                .collect(Collectors.groupingBy(
                                matches -> WinningInfo.checkMatch(matches),
                                Collectors.counting()
                        )
                );
    }

    public double calculateProfitRatio(long totalEarnings, long purchaseAmount){
        return  (double) totalEarnings / purchaseAmount;
    }

}
