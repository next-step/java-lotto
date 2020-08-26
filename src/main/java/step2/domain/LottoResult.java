package step2.domain;

import java.util.Map;

public class LottoResult {
    private Map<Integer, Long> resultMap;

    public LottoResult(Map<Integer, Long> map) {
        this.resultMap = map;
    }

    public Map<Integer, Long> getResultMap() {
        return resultMap;
    }

    public double getMargin(String lottoMoney) {
        int marginMoney = 0;
        for (Map.Entry<Integer, Long> map : resultMap.entrySet()) {
            int money = LottoMatchingCount.toLottoMatchingCount(map.getKey()).getMoney();
            marginMoney += money * map.getValue();
        }
        return Math.round((double) marginMoney / Double.parseDouble(lottoMoney) * 100) / 100.0;
    }
}
