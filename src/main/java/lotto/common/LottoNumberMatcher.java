package lotto.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.domain.LottoTicket;

public class LottoNumberMatcher {

    public static final int MINIMUM_MATCH_COUNT = 3;
    private Map<Integer, Integer> matchResult;

    public LottoNumberMatcher(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        this.matchResult = new HashMap<>();
        lottoTickets.forEach(lottoTicket -> {
            int matchCount = lottoTicket.matchNumbers(winningTicket);
            addMatchCount(matchCount);
        });
    }

    private void addMatchCount(int matchCount) {
        if (matchCount < MINIMUM_MATCH_COUNT) {
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

    public double calculateProfit(long money) {
        long totalPrice = LottoPriceInfo.calculateTotalPrice(matchResult);
        return Math.ceil(totalPrice * 100.0 / money) / 100.0;
    }

    public int getMatchTicketCount(int matchCount) {
        return matchResult.getOrDefault(matchCount, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumberMatcher that = (LottoNumberMatcher) o;
        return Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResult);
    }
}
