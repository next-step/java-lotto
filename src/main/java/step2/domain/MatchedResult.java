package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchedResult {
    private Map<Lottery, Integer> resultMap;

    public MatchedResult() {
        this.resultMap = new HashMap<>();
    }

    public void putMatchedResult(Lottery lottery, int matchedCount) {
        resultMap.put(lottery, matchedCount);
    }

    /**
     * 총 당첨 금액을 계산하는 메소드
     * @return 당첨 금액
     */
    public int getProfit() {
        int profit = 0;

        for (int count : resultMap.values()) {
            profit += Prize.getWinningMoney(count);
        }

        return profit;
    }

    /***
     * 로또 묶음 중 일치하는 장 수 반환하는 메소드
     * @param number 몇 개 일치하는지 숫자
     * @return 일치하는 복권의 장 수 (개수)
     */
    public int getCount(int number) {
        return (int) resultMap.values().stream()
                                        .filter(count -> number == count)
                                        .count();
    }
}
