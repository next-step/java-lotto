package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<String, Integer> resultMap;
    private double profitRate;

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        this.resultMap = matchList( lottoNumbers, winningNumbers);
    }

    private Map<String, Integer> matchList(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        Map<String, Integer> map = new HashMap<>();
        initMap(map);

        for (LottoNumber lottoNumber : lottoNumbers) {
            String count = String.valueOf(lottoNumber.matches(winningNumbers));
            int preCount = map.get(count);

            map.put(count, preCount + 1);
        }
        return map;
    }

    private void initMap(Map<String, Integer> map) {
        for (int idx = 0; idx <= 6; idx++) {
            map.put(String.valueOf(idx), 0);
        }
    }

    public void statistics(int money) {
        double profit = resultMap.keySet().stream()
                                .map(String::valueOf)
                                .filter(v -> Integer.parseInt(v) >= 3)
                                .mapToDouble(v -> (LottoPrize.getPrize(v) * resultMap.get(v)))
                                .sum();
        profitRate = profit / money;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
