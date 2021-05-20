package lotto.domain;

import java.util.Map;

public class LottoResult {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;
    public static final String PRIZE_RESULT_FORMAT_MESSAGE = "%d개 일치 (%d원)- %d개";
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

    public String resultMessage() {
        StringBuilder sb = new StringBuilder();
        result.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Prize.NONE)
                .forEach(entry -> {
                    Prize prize = entry.getKey();
                    sb.append(String.format(PRIZE_RESULT_FORMAT_MESSAGE, prize.getMatchCount(), prize.getRewardPrice(), entry.getValue()))
                            .append("\n");
                });
        return sb.toString();
    }
}
