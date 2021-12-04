package step2.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final LottoWinningRules lottoWinningRules;
    private final List<LottoNumbers> lottoNumbersList;
    private final int price;

    Lotto(LottoWinningRules lottoWinningRules, List<LottoNumbers> lottoNumbersList, int price) {
        this.lottoWinningRules = lottoWinningRules;
        this.lottoNumbersList = lottoNumbersList;
        this.price = price;
    }

    public Map<Integer, Integer> countNumberOfMatching(LottoWinningNumbers lottoWinningNumbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            int numberOfMatching = lottoNumbers.numberOfMatching(lottoWinningNumbers);
            int count = map.getOrDefault(numberOfMatching, 1);
            map.put(numberOfMatching, count);
        }
        return map;
    }

    public int prizeMoney(LottoWinningNumbers lottoWinningNumbers) {
        Map<Integer, Integer> countNumberOfMatching = countNumberOfMatching(lottoWinningNumbers);
        return prizeMoney(countNumberOfMatching);
    }

    public int prizeMoney(Map<Integer, Integer> countNumberOfMatching) {
        return countNumberOfMatching.entrySet().stream()
                .map(m -> {
                    int numberOfMatching = m.getKey();
                    int prizeMoney = lottoWinningRules.getPrizeOf(numberOfMatching);
                    int count = m.getValue();
                    return prizeMoney * count;
                })
                .reduce(0, Integer::sum);
    }

    public int earningRate(LottoWinningNumbers lottoWinningNumbers) {
        int prizeMoney = prizeMoney(lottoWinningNumbers);
        return prizeMoney / price;
    }

    public int earningRate(Map<Integer, Integer> countNumberOfMatching) {
        int prizeMoney = prizeMoney(countNumberOfMatching);
        return prizeMoney / price;
    }

    public int size() {
        return lottoNumbersList.size();
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return Collections.unmodifiableList(lottoNumbersList);
    }

    public LottoWinningRules getLottoWinningRules() {
        return lottoWinningRules;
    }

}
