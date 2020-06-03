package lotto.domain.prize;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {
    public Map<Integer, Integer> calculateWinningStatistics(List<Lotto> lottoTicket, List<Integer> winningNumbers) {
        WinningChecker winningChecker = new WinningChecker();
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (Lotto lotto : lottoTicket) {
            int winCount = winningChecker.checkWinNumber(lotto.getLottoNumber(), winningNumbers);
            matchCountMap.put(winCount, matchCountMap.getOrDefault(winCount, 0) + 1);

        }
        return matchCountMap;
    }

    public int calculateWinPrize(Map<Integer, Integer> matchCountMap) {
        int winPrize = 0;
        for (Prize prize : Prize.values()) {
            int matchCount = matchCountMap.get(prize.getMatch());
            winPrize += prize.calculate(matchCount);
        }
        return winPrize;
    }

    public double calculateWinRate(double purchaseAmount, double winPrize) {
        double winRate = winPrize / purchaseAmount;
        winRate = Math.floor(winRate * 100) / 100.0;
        return winRate;
    }

}
