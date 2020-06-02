package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<LottoNumber> lottoNumbers;
    private final List<Integer> winningNumbers;
    private final Map<String, Integer> resultMap;

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        resultMap = new HashMap<>();
    }

    public void matchList() {
        for (LottoNumber lottoNumber : lottoNumbers) {
            String count = String.valueOf(lottoNumber.matches(winningNumbers));
            int preCount = (resultMap.get(count) == null) ? 0 : resultMap.get(count);
            resultMap.put(count, preCount + 1);
        }
    }

    public double statistics(int money) {
        double profit = resultMap.keySet().stream()
                                .map(String::valueOf)
                                .filter(v -> Integer.parseInt(v) >= 3)
                                .mapToDouble(v -> (LottoPrize.getPrize(v) * resultMap.get(v)))
                                .sum();
        return profit / money;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }
}
