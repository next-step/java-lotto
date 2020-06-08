package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static Map<Rank, Integer> result;

    public LottoResult() {
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> matchResult(List<Lotto> lottos, WinningNumber winningNumber) {
        List<LottoNumber> winningNumbers = winningNumber.getWinningNumbers();

        for (Lotto lotto : lottos) {
            int countOfMatch = lotto.matches(winningNumbers);
            boolean matchBonus = lotto.isContainBonus(winningNumber.getBonusNumber());
            Rank rank = Rank.valueOf(countOfMatch, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }
}
