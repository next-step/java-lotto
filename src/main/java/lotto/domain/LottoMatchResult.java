package lotto.domain;

import lotto.common.LottoPriceInfo;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class LottoMatchResult {

    private Map<LottoPriceInfo, Long> matchResult;
    private double profit;

    public LottoMatchResult(List<LottoPriceInfo> lottoPriceInfoList, int money) {
        this.matchResult = lottoPriceInfoList.stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        this.profit = calculateProfit(money);
    }

    private double calculateProfit(int money) {
        long totalPrice = matchResult.entrySet().stream()
                .mapToLong(value -> value.getKey().calculatePrice(value.getValue()))
                .sum();

        return Math.ceil(totalPrice * 100.0 / money) / 100.0;
    }

//    public int getMatchTicketCount(int matchCount) {
//        return matchResult.getOrDefault(matchCount, 0);
//    }

    public double getProfit() {
        return profit;
    }

    public boolean isContainMatchCount(LottoPriceInfo lottoPriceInfo) {
        return matchResult.containsKey(lottoPriceInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoMatchResult that = (LottoMatchResult) o;
        return Double.compare(that.profit, profit) == 0 &&
                Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResult, profit);
    }

    public Long matchCount(LottoPriceInfo p1) {
        return matchResult.getOrDefault(p1, 0L);
    }
}
