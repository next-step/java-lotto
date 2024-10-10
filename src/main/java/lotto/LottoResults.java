package lotto;

import java.util.Map;

public class LottoResults {
    private final Map<Integer, Integer> prize;

    public LottoResults(Map<Integer, Integer> prize) {
        this.prize = prize;
    }

    public void addResult(int lottoResult) {
        prize.put(lottoResult,prize.getOrDefault(lottoResult,0)+1);
    }
}
