package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private Map<Rank, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new HashMap<>();
        this.winningResult = initMap(winningResult);
    }

    private Map<Rank, Integer> initMap(Map<Rank, Integer> winningResult) {
        for (Rank lotto : Rank.values()) {
            winningResult.put(lotto, 0);
        }
        return winningResult;
    }

    public Map<Rank, Integer> putRank(Rank rank) {
        if (winningResult.get(rank) != null) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
        return winningResult;
    }

    public WinningResult matchWinningNumber(WinningNumber winningNumber, List<Integer> winningNumbers, LottoTickets lottoTickets) {
        WinningResult winningResult = new WinningResult();
        for (int i = 0; i < lottoTickets.count(); i++) {
            int matchCount = 0;
            LottoTicket lottoTicket = lottoTickets.getLottoTicket(i);
            matchCount = winningNumber.findLottoTicket(winningNumbers, lottoTicket, matchCount);
            Rank rank = Rank.valudOf(matchCount);
            winningResult.putRank(rank);
        }
        return winningResult;
    }

    public Integer getWinningResult(Rank rank) {
        return winningResult.get(rank);
    }

}
