package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final long INITIAL_COUNT = 0L;
    private static final long PLUS_COUNT = 1L;

    public AccordanceCount collectAccordanceCount(Lottos lottos, WinningNumbers winningNumbers) {
        List<Long> accordanceCounts = lottos.getAccordanceCounts(winningNumbers);
        Map<WinningAccordance, Long> countsByWinningAccordance = collectEachAccordanceCount(accordanceCounts);

        return new AccordanceCount(countsByWinningAccordance);
    }

    public double calculateProfitRatio(AccordanceCount accordanceCount, PurchaseMoney purchaseMoney) {
        long totalWinningPrize = accordanceCount.calculateTotalPrize();
        return (double) totalWinningPrize / purchaseMoney.getValue();
    }

    private Map<WinningAccordance, Long> collectEachAccordanceCount(List<Long> accordanceCounts) {
        Map<WinningAccordance, Long> countsByWinningAccordance = initCountsByWinningAccordance();
        for (long accordCount : accordanceCounts) {
            countsByWinningAccordance.computeIfPresent(
                    WinningAccordance.of(accordCount),
                    (winningAccordance, count) -> count + PLUS_COUNT
            );
        }

        return Map.copyOf(countsByWinningAccordance);
    }

    private Map<WinningAccordance, Long> initCountsByWinningAccordance() {
        Map<WinningAccordance, Long> countsByWinningAccordance = new EnumMap<>(WinningAccordance.class);
        for (WinningAccordance winningAccordance : WinningAccordance.validValues()) {
            countsByWinningAccordance.put(winningAccordance, INITIAL_COUNT);
        }

        return countsByWinningAccordance;
    }
}
