package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;
    public static final int BENEFIT_STANDARD_RATE = 1;
    public static final String PRIZE_RESULT_FORMAT_MESSAGE = "%d개 일치 (%d원)- %d개";
    public static final String PROFIT_RATE_NOTICE_MESSAGE = "총 수익률은 %.2f입니다.";
    public static final String APPEND_MESSAGE_BY_CONDITION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final Map<Prize, Integer> result;

    public LottoResult(Map<Prize, Integer> result) {
        this.result = result;
    }

    public int prizeCount(Prize prize) {
        return result.getOrDefault(prize, ZERO);
    }

    public double calculateProfitRate(int price) {
        int profit = ZERO;
        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            profit += entry.getKey().calculateProfit(entry.getValue());
        }
        return Math.floor((double) profit / price * HUNDRED) / HUNDRED ;
    }

    public String resultMessage(int price) {
        return statisticsMessage() +
                profitRateMessage(calculateProfitRate(price));
    }

    private String statisticsMessage() {
        return result.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Prize.NONE)
                .map(entry -> {
                    Prize prize = entry.getKey();
                    return String.format(PRIZE_RESULT_FORMAT_MESSAGE, prize.getMatchCount(), prize.getRewardPrice(), entry.getValue());
                })
                .collect(Collectors.joining("\n"));
    }

    private String profitRateMessage(double calculateProfitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PROFIT_RATE_NOTICE_MESSAGE, calculateProfitRate));

        if (calculateProfitRate < BENEFIT_STANDARD_RATE) {
            sb.append(APPEND_MESSAGE_BY_CONDITION);
        }
        return sb.toString();
    }
}
