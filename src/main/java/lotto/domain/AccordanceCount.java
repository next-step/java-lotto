package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccordanceCount {

    private final Map<WinningAccordance, Long> countsByWinningAccordance;

    public AccordanceCount(Map<WinningAccordance, Long> countsByWinningAccordance) {
        this.countsByWinningAccordance = countsByWinningAccordance;
    }

    public List<Map.Entry<WinningAccordance, Long>> getCountsByWinningAccordanceInSequence() {
        return countsByWinningAccordance.entrySet()
            .stream()
            .sorted(Comparator.comparing(entry -> entry.getKey().getMatchCount()))
            .collect(Collectors.toList());
    }

    public long calculateTotalPrize() {
        return countsByWinningAccordance.entrySet()
            .stream()
            .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }
}
