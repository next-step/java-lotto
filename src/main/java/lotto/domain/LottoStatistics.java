package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final long INITIAL_COUNT = 0L;

    public AccordanceCount collectAccordanceCount(Lottos lottos, WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        List<Accordance> accordances = lottos.getAccordances(winningNumbers, bonusNumber);
        Map<WinningAccordance, Long> countsByWinningAccordance = collectEachAccordanceCount(accordances);

        return new AccordanceCount(countsByWinningAccordance);
    }

    public double calculateProfitRatio(AccordanceCount accordanceCount, PurchaseMoney purchaseMoney) {
        long totalWinningPrize = accordanceCount.calculateTotalPrize();
        return (double) totalWinningPrize / purchaseMoney.getValue();
    }

    private Map<WinningAccordance, Long> collectEachAccordanceCount(List<Accordance> accordances) {
        Map<WinningAccordance, Long> countsByWinningAccordance = initCountsByWinningAccordance();
        for (Accordance accordance : accordances) {
            countsByWinningAccordance.computeIfPresent(
                WinningAccordance.of(accordance),
                (winningAccordance, count) -> count + 1L
            );
        }

        return countsByWinningAccordance;
    }

    private Map<WinningAccordance, Long> initCountsByWinningAccordance() {
        Map<WinningAccordance, Long> countsByWinningAccordance = new EnumMap<>(WinningAccordance.class);
        for (WinningAccordance winningAccordance : WinningAccordance.validValues()) {
            countsByWinningAccordance.put(winningAccordance, INITIAL_COUNT);
        }

        return countsByWinningAccordance;
    }
}
