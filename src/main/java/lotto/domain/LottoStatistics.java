package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final long INITIAL_COUNT = 0L;

    public AccordanceCount collectAccordanceCount(Lottos lottos, WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        List<Long> accordanceCounts = lottos.getAccordanceCounts(winningNumbers);
        Map<WinningAccordance, Long> countsByWinningAccordance = collectEachAccordanceCount(accordanceCounts);

        long countOfSecondWinningAccordance = lottos.countMatchingFiveNumberAndBonusNumber(winningNumbers, bonusNumber);
        calculateMatchingBonusNumberCount(countsByWinningAccordance, countOfSecondWinningAccordance);

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
                (winningAccordance, count) -> count + 1L
            );
        }

        return countsByWinningAccordance;
    }

    private void calculateMatchingBonusNumberCount(
        Map<WinningAccordance, Long> countsByWinningAccordance, long countOfSecondWinningAccordance
    ) {
        countsByWinningAccordance.computeIfPresent(
            WinningAccordance.THIRD,
            (winningAccordance, count) -> count - countOfSecondWinningAccordance
        );

        countsByWinningAccordance.computeIfPresent(
            WinningAccordance.SECOND,
            (winningAccordance, count) -> count + countOfSecondWinningAccordance
        );
    }

    private Map<WinningAccordance, Long> initCountsByWinningAccordance() {
        Map<WinningAccordance, Long> countsByWinningAccordance = new EnumMap<>(WinningAccordance.class);
        for (WinningAccordance winningAccordance : WinningAccordance.validValues()) {
            countsByWinningAccordance.put(winningAccordance, INITIAL_COUNT);
        }

        return countsByWinningAccordance;
    }
}
