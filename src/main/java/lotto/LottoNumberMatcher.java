package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoNumberMatcher {
    private Map<Integer, Integer> matchResult;

    public LottoNumberMatcher(List<Integer> lastWeekWinningNumbers, List<LottoTicket> lottoTickets) {
        this.matchResult = new HashMap<>();

        lottoTickets.forEach(lottoTicket -> {
            int matchCount = lottoTicket.matchNumbers(lastWeekWinningNumbers);
            addMatchCount(matchCount);
        });
    }

    private void addMatchCount(int matchCount) {
        if (matchCount < 3) {
            return;
        }

        if (matchResult.containsKey(matchCount)) {
            matchResult.put(matchCount, matchResult.get(matchCount) + 1);
            return;
        }

        matchResult.putIfAbsent(matchCount, 1);
    }

    public LottoNumberMatcher(Map<Integer, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberMatcher that = (LottoNumberMatcher) o;
        return Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResult);
    }
}
