package step2.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final LottoWinningRules lottoWinningRules;
    private final List<Lotto> lottoList;
    private final int price;

    Lottos(LottoWinningRules lottoWinningRules, List<Lotto> lottoList, int price) {
        this.lottoWinningRules = lottoWinningRules;
        this.lottoList = lottoList;
        this.price = price;
    }

    public Map<Integer, Integer> countNumberOfMatching(LottoWinningNumbers lottoWinningNumbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int numberOfMatching = lotto.numberOfMatching(lottoWinningNumbers);
            int count = map.getOrDefault(numberOfMatching, 0);
            map.put(numberOfMatching, count + 1);
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

    public double earningRate(LottoWinningNumbers lottoWinningNumbers) {
        int prizeMoney = prizeMoney(lottoWinningNumbers);
        return (double)prizeMoney / price;
    }

    public double earningRate(Map<Integer, Integer> countNumberOfMatching) {
        int prizeMoney = prizeMoney(countNumberOfMatching);
        return (double)prizeMoney / price;
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> getLottoNumbersList() {
        return Collections.unmodifiableList(lottoList);
    }

    public LottoWinningRules getLottoWinningRules() {
        return lottoWinningRules;
    }

}
