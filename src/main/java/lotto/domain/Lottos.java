package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private static final int DEFAULT_COUNT = 0;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getLotto(int index) {
        return this.lottos.get(index);
    }

    public int getSize() {
        return this.lottos.size();
    }

    public LottoStatistics getLottoStatisticsByWinningNumbers(LottoNumbers winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : this.lottos) {
            int matchingCount = lotto.getCountOfMatchingNumber(winningNumbers);
            int lottoCount = result.getOrDefault(matchingCount, DEFAULT_COUNT);
            result.put(matchingCount, ++lottoCount);
        }
        WinningCounts winningCounts = new WinningCounts(filterWinningNumbers(result));
        return new LottoStatistics(winningCounts);
    }

    private Map<Integer, Integer> filterWinningNumbers(Map<Integer, Integer> result) {
        return result.entrySet().stream()
                .filter(this::isWinningNumber)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean isWinningNumber(Map.Entry<Integer, Integer> entry) {
        return entry.getKey() >= WinningCounts.WINNING_NUMBER_MINIMUM
                && entry.getKey() <= WinningCounts.WINNING_NUMBER_MAXIMUM;
    }
}
