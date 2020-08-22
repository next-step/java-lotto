package lotto;

import java.util.*;

public class LottoNumberMatcher {
    private Map<Integer, Integer> matchResult;
    private double profit;

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

    public double calculateProfit(long money) {
        long totalPrice = LottoPriceInfo.calculateTotalPrice(matchResult);
        profit = Math.ceil(totalPrice * 100.0 / money) / 100.0;

        return profit;
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
