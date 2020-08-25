package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.utils.CommonConstant.*;

public class WinningResult {

    private Map<Rank, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new HashMap<>();
        initMap(winningResult);
    }

    private Map<Rank, Integer> initMap(Map<Rank, Integer> winningResult) {
        for (Rank lotto : Rank.values()) {
            winningResult.put(lotto, NUMBER_ZERO);
        }
        return winningResult;
    }

    public Map<Rank, Integer> putRank(Rank rank) {
        if (winningResult.get(rank) != null) {
            winningResult.put(rank, winningResult.get(rank) + NUMBER_ONE);
        }
        return winningResult;
    }

    public WinningResult getWinningResult(List<Integer> winningNumbers, LottoStore lottoTickets, int bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for (int i = NUMBER_ZERO; i < lottoTickets.size(); i++) {
            LottoTicket lottoTicket = lottoTickets.getLottoTicket(i);
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            boolean checkBonusNumber = isBonusNumber(bonusNumber, matchCount, lottoTicket.getLottoTicket());
            Rank rank = Rank.valudOf(matchCount, checkBonusNumber);
            winningResult.putRank(rank);
        }
        return winningResult;
    }

    private boolean isBonusNumber(int bonusNumber, int matchCount, List<Integer> lottoTicket) {
        if (matchCount == NUMBER_FIVE) {
            return WinningNumber.isContainsBonusNumber(lottoTicket, bonusNumber);
        }
        return false;
    }

    public Integer getWinningResult(Rank rank) {
        return winningResult.get(rank);
    }

}
