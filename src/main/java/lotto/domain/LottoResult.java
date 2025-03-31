package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 당첨 결과를 저장
 */
public class LottoResult {
    private final LottoTicket winningLotto;
    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoResult(List<Integer> winningNumbers, List<List<Integer>> lottos) {
        winningLotto = new LottoTicket(winningNumbers);
        for (List<Integer> lotto : lottos) {
            int matchCount = calculateMatchCount(winningLotto, lotto);
            Rank rank = Rank.valueOf(matchCount);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public int calculateMatchCount(LottoTicket winningLotto, List<Integer> lottos) {
        return (int) lottos.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

}
