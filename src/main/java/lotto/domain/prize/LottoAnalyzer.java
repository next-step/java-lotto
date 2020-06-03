package lotto.domain.prize;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {
    public Map<Integer, Integer> calculateWinningStatistics(List<Lotto> lottoTicket, List<Integer> winningNumbers) {
        WinningChecker winningChecker = new WinningChecker();
        Map<Integer, Integer> statistics = new HashMap<>();
        for (Lotto lotto : lottoTicket) {
            int winCount = winningChecker.checkWinNumber(lotto.getLottoNumber(), winningNumbers);
            statistics.put(winCount, statistics.getOrDefault(winCount, 0) + 1);

        }
        return statistics;
    }
}
