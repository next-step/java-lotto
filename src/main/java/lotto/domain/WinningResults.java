package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResults {

    private final List<WinningType> winningTypes;

    public WinningResults(List<WinningType> winningTypes) {
        this.winningTypes = winningTypes;
    }

    public long count(WinningType winningType) {
        return winningTypes.stream()
                .filter(type -> type.equals(winningType))
                .count();
    }

    public Money sumPrizes() {
        return winningTypes.stream()
                .map(WinningType::getPrize)
                .reduce(Money::sum)
                .orElse(Money.NONE);
    }

    public List<WinningType> getResults() {
        return new ArrayList<>(winningTypes);
    }
}
