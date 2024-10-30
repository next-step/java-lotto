package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class WinningResults {
    private static final int MIN_MATCH_COUNT = 3;
    private static final int MAX_MATCH_COUNT = 6;

    private Map<Integer, Integer> results = new HashMap<>();;

    public WinningResults(LottoManager lottoManager, WinningLotto winningLotto) {
        init();
        calculateResults(lottoManager, winningLotto);
    }

    private void init() {
        IntStream.rangeClosed(MIN_MATCH_COUNT, MAX_MATCH_COUNT)
                .forEachOrdered(matchCount -> results.put(matchCount, 0));
    }

    private void calculateResults(LottoManager lottoManager, WinningLotto winningLotto) {
        lottoManager.purchasedLottos()
                .stream()
                .mapToInt(winningLotto::countMatchingNumbers)
                .forEach(this::updateResults);
    }

    private void updateResults(int matchCount) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }
        
        if (results.containsKey(matchCount)) {
            results.put(matchCount, results.get(matchCount) + 1);
        }
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }

}
